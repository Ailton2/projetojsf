package br.com.projetojsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetojsf.util.HibernateUtil;

public class DaoGeneric<E> {
	
	
	private EntityManager entityManager = HibernateUtil.entityManager();
	
	public void salvar(E entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
		
	}

	
}
