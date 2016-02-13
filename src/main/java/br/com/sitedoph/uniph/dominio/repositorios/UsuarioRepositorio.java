package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.UsuarioDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class UsuarioRepositorio {

	private EntityManager em;
	private UsuarioDAO DAO;

	private void criarDAOeEM() {
		em = JPAUtil.getEntityManager();
		DAO = new UsuarioDAO(em);
	}

	public Usuario buscarPorId(Long id) {

		criarDAOeEM();

		Usuario u = DAO.buscarPorId(id);

		em.close();

		return u;
	}

	public Usuario buscarPorLoginESenha(String login, String senha) {

		criarDAOeEM();

		Usuario u = DAO.buscarPorLoginESenha(login, senha);

		em.close();

		return u;
	}

	public List<Usuario> buscarTodos() {

		criarDAOeEM();

		List<Usuario> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public void excluir(final Usuario usuario) {

		criarDAOeEM();

		em.getTransaction().begin();

		try {
			DAO.excluir(usuario);
			em.getTransaction().commit();
		} catch (final Exception e) {
			em.getTransaction().rollback();
		}

		em.close();

	}

	public Usuario salvarOuAtualizar(Usuario usuario) {

		criarDAOeEM();

		em.getTransaction().begin();

		try {
			usuario = DAO.salvarOuAtualizar(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return usuario;
	}
}
