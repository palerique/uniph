package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class UsuarioDAOTest {

	private static final String SENHA = "123456";
	private static final String MARQUINHOS = "marquinhos";

	@Test
	public void deveSalvar() {

		EntityManager em = JPAUtil.getEntityManager();

		UsuarioDAO dao = new UsuarioDAO(em);

		Usuario loginESenha = dao.buscarPorLoginESenha(MARQUINHOS, SENHA);

		em.getTransaction().begin();
		if (loginESenha != null) {
			dao.excluir(loginESenha);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();

		Usuario marcos = new Usuario();

		marcos.setEmail("marcos@marcos.com");
		marcos.setNomeCompleto("Marcos Gregório");
		marcos.setLogin(MARQUINHOS);
		marcos.setSenha(SENHA);

		marcos = dao.salvarOuAtualizar(marcos);

		em.getTransaction().commit();

		Usuario buscarPorId = dao.buscarPorId(marcos.getId());

		Assert.assertEquals(marcos.getId(), buscarPorId.getId());
		Assert.assertEquals(marcos.getEmail(), buscarPorId.getEmail());
		Assert.assertEquals(marcos.getLogin(), buscarPorId.getLogin());
		Assert.assertEquals(marcos.getNomeCompleto(), buscarPorId.getNomeCompleto());
		Assert.assertEquals(marcos.getSenha(), buscarPorId.getSenha());

		List<Usuario> buscarTodos = dao.buscarTodos();

		for (Usuario usuario : buscarTodos) {
			System.out.println(usuario);
		}

		em.close();

	}

}
