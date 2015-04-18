package com.yh.banque.models;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.yh.banque.entities.Compte;
import com.yh.banque.entities.Operation;

public class BanqueForm {
	@NotEmpty
	@Size(min=3,max=10)
  private String code;
  private Compte compte;
  private String typeCompte;
  private String exception;
  private List<Operation> operations;
  
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}
public String getTypeCompte() {
	return typeCompte;
}
public void setTypeCompte(String typeCompte) {
	this.typeCompte = typeCompte;
}
public String getException() {
	return exception;
}
public void setException(String exception) {
	this.exception = exception;
}
public List<Operation> getOperations() {
	return operations;
}
public void setOperations(List<Operation> operations) {
	this.operations = operations;
}


  
}
