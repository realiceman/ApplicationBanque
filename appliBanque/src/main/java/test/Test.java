package test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yh.banque.entities.Client;
import com.yh.banque.entities.CompteCourant;
import com.yh.banque.entities.CompteEpargne;
import com.yh.banque.entities.Employe;
import com.yh.banque.entities.Groupe;
import com.yh.banque.metier.IBanqueMetier;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IBanqueMetier metier= (IBanqueMetier) context.getBean("metier");
		metier.addClient(new Client("client1", "adresse1"));
		metier.addClient(new Client("client2", "adresse2"));
        metier.addEmploye(new Employe("employe1"), null);
        metier.addEmploye(new Employe("employe2"), 1L);
        metier.addEmploye(new Employe("employe3"), 1L);
        metier.addGroupe(new Groupe("groupe1"));
        metier.addGroupe(new Groupe("groupe2"));
        metier.addEmployeToGroupe(1L, 1L);
        metier.addEmployeToGroupe(2L, 2L);
        metier.addEmployeToGroupe(3L, 2L);
       
        metier.addCompte(new CompteCourant("CC1", new Date(), 9000, 8000), 1L, 2L);
        metier.addCompte(new CompteEpargne("CE1", new Date(), 40000, 5.5), 2L, 2L);
        
        metier.verser(5000, "CC1", 2L);
        metier.retirer(6000, "CC1", 2L);
        
        metier.virement(4000, "CC1", "CE1", 1L);
	}

}
