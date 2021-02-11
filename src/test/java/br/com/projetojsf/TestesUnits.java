package br.com.projetojsf;

import org.junit.Test;

import br.com.projetojsf.util.HibernateUtil;

public class TestesUnits {
	
	@Test
	public void testeHibernate() {
		
		HibernateUtil.entityManager();
	}

}
