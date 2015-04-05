package com.yh.banque.entities;

import java.util.Date;

public class CompteEpargne  extends Compte{
 private double taux;

public CompteEpargne() {
	super();
	// TODO Auto-generated constructor stub
}

public CompteEpargne(String codeCompte, Date dateCreation, double solde,
		double taux) {
	super(codeCompte, dateCreation, solde);
	this.taux = taux;
}

public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}
 
 
}