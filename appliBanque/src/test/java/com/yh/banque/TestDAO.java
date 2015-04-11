package com.yh.banque;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yh.banque.entities.Client;
import com.yh.banque.metier.IBanqueMetier;

public class TestDAO {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app=
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
	}

}
