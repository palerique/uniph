package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class UsuarioDAOTest {

	@Test
	public void deveSalvar() {

		EntityManager em = JPAUtil.getEntityManager();

		UsuarioDAO dao = new UsuarioDAO(em);

		em.getTransaction().begin();

		Usuario marcos = new Usuario();

		marcos.setEmail("marcos@marcos.com");
		marcos.setNomeCompleto("Marcos Gregório");
		marcos.setLogin("marquinhos");
		marcos.setSenha("123456");

		marcos = dao.salvarOuAtualizar(marcos);

		em.getTransaction().commit();

		Usuario buscarPorId = dao.buscarPorId(marcos.getId());

		Assert.assertEquals(marcos.getId(), buscarPorId.getId());
		Assert.assertEquals(marcos.getEmail(), buscarPorId.getEmail());
		Assert.assertEquals(marcos.getLogin(), buscarPorId.getLogin());
		Assert.assertEquals(marcos.getNomeCompleto(), buscarPorId.getNomeCompleto());
		Assert.assertEquals(marcos.getSenha(), buscarPorId.getSenha());

		em.close();

	}

}
