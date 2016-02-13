package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;

public class ProfessorDAO {

	private final GenericDAO<Professor, Long> DAO;

	public ProfessorDAO(EntityManager entityManager) {
		DAO = new GenericDAOHibernate<>(entityManager, Professor.class);
	}

	public Professor buscarCPF(String cpf) {

		Professor exemplo = new Professor();

		exemplo.setCpf(cpf);

		List<Professor> porExemplo = DAO.buscarPorExemplo(exemplo);

		if (porExemplo != null && !porExemplo.isEmpty()) {
			return porExemplo.get(0);
		} else {
			return null;
		}
	}

	public void excluir(Professor entidade) {
		DAO.excluir(entidade);
	}

	public Professor salvarOuAtualizar(Professor entidade) {
		return DAO.salvarOuAtualizar(entidade);
	}

	public Professor buscarPorId(Long id) {
		return DAO.buscarPorId(id);
	}

	public List<Professor> buscarTodos() {
		return DAO.buscarTodos();
	}

}
