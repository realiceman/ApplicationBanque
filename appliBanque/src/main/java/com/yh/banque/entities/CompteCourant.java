package com.yh.banque.entities;

import java.util.Date;

public class CompteCourant extends Compte {
 private double decouvert;


public CompteCourant() {
	super();
	// TODO Auto-generated constructor stub
}

public CompteCourant(String codeCompte, Date dateCreation, double solde,
		double decouvert) {
	super(codeCompte, dateCreation, solde);
	this.decouvert = decouvert;
}



public double getDecouvert() {
	return decouvert;
}

public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}
 
 
}
