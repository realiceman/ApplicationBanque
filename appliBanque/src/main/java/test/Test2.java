package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yh.banque.entities.Compte;
import com.yh.banque.entities.Operation;
import com.yh.banque.metier.IBanqueMetier;

public class Test2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IBanqueMetier metier= (IBanqueMetier) context.getBean("metier");
		
		Compte cp = metier.consulterCompte("CC1");
		
		System.out.println("solde: "+ cp.getSolde());
		System.out.println("date :"+ cp.getDateCreation());
	    System.out.println("client :"+ cp.getClient().getNomClient());
	    System.out.println("Employé :"+ cp.getEmploye().getNomEmploye());
	    List<Operation> ops = metier.consulterOperations("CC1");
	    for (Operation op : ops) {
	    	System.out.println("************");
	    	System.out.println(op.getNumeroOperation());
	    	System.out.println(op.getDateOperation());
	    	System.out.println(op.getMontant());
	    	System.out.println(op.getClass().getSimpleName());
			
		}
	}

}
