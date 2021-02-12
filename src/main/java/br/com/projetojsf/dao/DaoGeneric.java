package br.com.projetojsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import br.com.projetojsf.util.HibernateUtil;

public class DaoGeneric<E> {
	
	
	private EntityManager entityManager = HibernateUtil.entityManager();
	
	public void salvar(E entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
		
	}
	
	public E consultar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;
	}
	
	public E updateMerge(E entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
	}

	
	public void deletar(E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		entityManager.createNativeQuery("delete from "+entidade.getClass()
		                          .getSimpleName().toLowerCase() +" where id = "+id).executeUpdate();
		
		transaction.commit();
	}
	
}
