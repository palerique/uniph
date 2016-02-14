package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;

import javax.persistence.EntityManager;
import java.util.List;

public class AlunoDAO {

	private final GenericDAO<Aluno, Long> DAO;

	public AlunoDAO(EntityManager entityManager) {
		DAO = new GenericDAOHibernate<>(entityManager, Aluno.class);
	}

	public Aluno buscarCPF(String cpf) {

		Aluno exemplo = new Aluno();

		exemplo.setCpf(cpf);

		List<Aluno> porExemplo = DAO.buscarPorExemplo(exemplo);

		if (porExemplo != null && !porExemplo.isEmpty()) {
			return porExemplo.get(0);
		} else {
			return null;
		}
	}

	public void excluir(Aluno entidade) {
		DAO.excluir(entidade);
	}

	public Aluno salvarOuAtualizar(Aluno entidade) {
		return DAO.salvarOuAtualizar(entidade);
	}

	public Aluno buscarPorId(Long id) {
		return DAO.buscarPorId(id);
	}

	public List<Aluno> buscarTodos() {
		return DAO.buscarTodos();
	}

}
