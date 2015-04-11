package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yh.banque.entities.Client;
import com.yh.banque.metier.IBanqueMetier;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IBanqueMetier metier= (IBanqueMetier) context.getBean("metier");
		metier.addClient(new Client("client1", "adresse1"));
		metier.addClient(new Client("client2", "adresse2"));

	}

}
