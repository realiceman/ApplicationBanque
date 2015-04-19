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
		try {
			Compte cp = metier.consulterCompte(bf.getCode());
			bf.setTypeCompte(cp.getClass().getSimpleName());
			bf.setCompte(cp);
			List<Operation> ops = metier.consulterOperations(bf.getCode());
			bf.setOperations(ops);
		} catch (Exception e) {
			bf.setException(e.getMessage());  //dao -> consulterCompte() ->  throw new RuntimeException("compte introuvable")
		}
		
		model.addAttribute("banqueForm", bf);
		return "banque";
	}
	
	@RequestMapping(value="/saveOperation")
	public String saveOp(@Valid BanqueForm bf, BindingResult bindingResult){
		
	      try {
				Compte cp = metier.consulterCompte(bf.getCode());
				bf.setTypeCompte(cp.getClass().getSimpleName());
				bf.setCompte(cp);
				
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
	        
		   List<Operation> ops = metier.consulterOperations(bf.getCode());
		   bf.setOperations(ops);
		   
		return "banque";
	}
}
