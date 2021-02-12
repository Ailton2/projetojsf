package br.com.projetojsf;

import org.junit.Test;

import br.com.projetojsf.classes.bean.Usuario;
import br.com.projetojsf.dao.DaoGeneric;
import br.com.projetojsf.util.HibernateUtil;

public class TestesUnits {
	
	@Test
	public void testeHibernate() {
		
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		
		Usuario user = new Usuario();
		user.setNome("Paulo");
		user.setSobrenome("Ferreira");
		user.setLogin("tim");
		user.setSenha("1234");
		
		daoGeneric.salvar(user);
	}
	
	@Test
	public void testConsultar() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		
		usuario = daoGeneric.consultar(usuario);
		
		System.out.println(usuario);
	}
	
	@Test
	public void testUpdate() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario = daoGeneric.consultar(usuario); //consulta
		
		usuario.setNome("testando"); //seta a atualizaçao
		
		usuario= daoGeneric.updateMerge(usuario); //atualiza
		
		
		System.out.println(usuario);
	}
	
	@Test
	public void testDelete() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario = daoGeneric.consultar(usuario); //consulta
		
		
		daoGeneric.deletar(usuario); //delete
		

	}

}
