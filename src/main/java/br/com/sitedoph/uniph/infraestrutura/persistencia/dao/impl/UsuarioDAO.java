package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDAO {

	private final GenericDAO<Usuario, Long> DAO;

	public UsuarioDAO(EntityManager entityManager) {

		DAO = new GenericDAOHibernate<>(entityManager, Usuario.class);

	}

	public Usuario buscarPorId(Long id) {
		return DAO.buscarPorId(id);
	}

	public Usuario buscarPorLoginESenha(String login, String senha) {

		Usuario exemplo = new Usuario();
		exemplo.setLogin(login);
		exemplo.setSenha(senha);

		List<Usuario> list = DAO.buscarPorExemplo(exemplo);

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<Usuario> buscarTodos() {
		return DAO.buscarTodos();
	}

	public void excluir(Usuario usuario) {
		DAO.excluir(usuario);
	}

	public Usuario salvarOuAtualizar(Usuario usuario) {
		return DAO.salvarOuAtualizar(usuario);
	}

}
