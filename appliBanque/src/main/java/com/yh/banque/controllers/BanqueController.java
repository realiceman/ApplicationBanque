package com.yh.banque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.banque.entities.Compte;
import com.yh.banque.entities.Operation;
import com.yh.banque.metier.IBanqueMetier;
import com.yh.banque.models.BanqueForm;

@Controller
@RequestMapping(value="/adminBanque")
public class BanqueController {
	@Autowired          // on demande a spring de chercher un objet deja créé pdt l'injec des dep,  et de l'associer au controleur
    private IBanqueMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("banqueForm", new BanqueForm());
		return "banque";
	}
	
	@RequestMapping(value="/chargerCompte")
	public String charger(@Valid BanqueForm bf, //au moment de créer banqueform, vérification des champs soumis à validator
		    	BindingResult bindingResult, Model model){ //et binding... pr faire un test s'il y a des erreurs de validation
		if(bindingResult.hasErrors()){
			return "banque";
		}
		chargerCompte(bf);
		
		model.addAttribute("banqueForm", bf);
		return "banque";
	}
	
	@RequestMapping(value="/saveOperation")
	public String saveOp(@Valid BanqueForm bf, BindingResult bindingResult){
		
		try {
					if(bindingResult.hasErrors()){
						return "banque";
					}
 
					
				   if(bf.getAction()!=null){	
									   if(bf.getTypeOperation().equalsIgnoreCase("VER")){
										   metier.verser(bf.getMontant(), bf.getCode(), 1L);
									   }
									   else if(bf.getTypeOperation().equalsIgnoreCase("RET")){
										  metier.retirer(bf.getMontant(), bf.getCode(), 1L);
									   }
									   else if(bf.getTypeOperation().equalsIgnoreCase("VIR")){
										   metier.virement(bf.getMontant(), bf.getCode(), bf.getCode2(), 1L);
									   }
				   }
			} catch (Exception e) {
				 bf.setException(e.getMessage());  //dao -> consulterCompte() ->  throw new RuntimeException("compte introuvable")
			}
		  
			   chargerCompte(bf);	 
		return "banque";
	}
	
	
	public void chargerCompte(BanqueForm bf){
		  try {
				Compte cp = metier.consulterCompte(bf.getCode());
				bf.setTypeCompte(cp.getClass().getSimpleName());
				bf.setCompte(cp);
				int pos=bf.getNbLignes()*bf.getPage(); //si page=0 je commence à 0, si page 1 je commence à 5....
			    List<Operation> ops = metier.consulterOperations(bf.getCode(),pos,bf.getNbLignes());
			    bf.setOperations(ops);
			    long nbOp=metier.getNombreOperation(bf.getCode());
			    bf.setNombrePages((int) (nbOp/bf.getNbLignes())+1);
	       }catch (Exception e) {
		        bf.setException(e.getMessage());  //dao -> consulterCompte() ->  throw new RuntimeException("compte introuvable")
	        }
   }
	
	
}