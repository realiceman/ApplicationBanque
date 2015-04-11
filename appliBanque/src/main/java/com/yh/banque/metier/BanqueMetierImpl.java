package com.yh.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yh.banque.dao.IBanqueDao;
import com.yh.banque.entities.Client;
import com.yh.banque.entities.Compte;
import com.yh.banque.entities.Employe;
import com.yh.banque.entities.Groupe;
import com.yh.banque.entities.Operation;
import com.yh.banque.entities.Retrait;
import com.yh.banque.entities.Versement;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
    private IBanqueDao dao;
    
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		// TODO Auto-generated method stub
		return dao.addEmploye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		// TODO Auto-generated method stub
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGroup) {
		// TODO Auto-generated method stub
        dao.addEmployeToGroupe(codeEmp, codeGroup);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.addCompte(cp, codeCli, codeEmp);
	}

	@Override
	public void verser(double mt, String cpte, Long codeEmp) {
		// TODO Auto-generated method stub
       dao.addOperation(new Versement(new Date(),mt), cpte, codeEmp);
       Compte cp=dao.consulterCompte(cpte);
       cp.setSolde(cp.getSolde()+mt);
	}

	@Override
	public void retirer(double mt, String cpte, Long codeEmp) {
		// TODO Auto-generated method stub
	     dao.addOperation(new Retrait(new Date(),mt), cpte, codeEmp);
	       Compte cp=dao.consulterCompte(cpte);
	       cp.setSolde(cp.getSolde()-mt);

	}

	@Override
	public void virement(double mt, String cpte1, String cpte2, Long codeEmp) {
    retirer(mt, cpte1, codeEmp);
    verser(mt, cpte2, codeEmp);

	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterCompte(codeCpte);
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterOperations(codeCpte);
	}

	@Override
	public Client consulterClient(Long codeClient) {
		// TODO Auto-generated method stub
		return dao.consulterClient(codeClient);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		// TODO Auto-generated method stub
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.getComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.getComptesByEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		// TODO Auto-generated method stub
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		// TODO Auto-generated method stub
		return dao.getEmployesByGroupe(codeGr);
	}

}
