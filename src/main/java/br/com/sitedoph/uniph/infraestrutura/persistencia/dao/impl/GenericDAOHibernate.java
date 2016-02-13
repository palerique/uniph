package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;

public class GenericDAOHibernate
				<T, ID extends Serializable> 
					implements GenericDAO<T, ID> {

	@Override
	public T salvarOuAtualizar(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T buscarPorId(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(T entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> buscarPorCriteria(Criterion... criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> buscarPorExemplo(T exemplo, String... propriedadesAExcluir) {
		// TODO Auto-generated method stub
		return null;
	}

}
