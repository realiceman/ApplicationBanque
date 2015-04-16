package com.yh.banque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.banque.entities.Compte;
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
	public String charger(BanqueForm bf, Model model){
		Compte cp = metier.consulterCompte(bf.getCode());
		bf.setCompte(cp);
		model.addAttribute("banqueForm", bf);
		return "banque";
	}
}
