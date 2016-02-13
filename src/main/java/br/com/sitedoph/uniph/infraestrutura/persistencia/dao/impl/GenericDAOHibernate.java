package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;

public class GenericDAOHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private final Class<T> CLASSE;

	private final EntityManager ENTITY_MANAGER;

	public GenericDAOHibernate(final EntityManager entityManager, final Class<T> classe) {

		ENTITY_MANAGER = entityManager;
		CLASSE = classe;

	}

	@Override
	public T salvarOuAtualizar(T entidade) {
		return ENTITY_MANAGER.merge(entidade);
	}

	@Override
	public T buscarPorId(ID id) {
		return ENTITY_MANAGER.find(CLASSE, id);
	}

	@Override
	public List<T> buscarTodos() {

		final CriteriaQuery<T> query = ENTITY_MANAGER.getCriteriaBuilder().createQuery(CLASSE);

		query.select(query.from(CLASSE));

		return ENTITY_MANAGER.createQuery(query).getResultList();
	}

	@Override
	public void excluir(T entidade) {
		// ENTITY_MANAGER.merge(entidade);
		ENTITY_MANAGER.remove(entidade);
	}

	@Override
	public List<T> buscarPorCriteria(
			Criterion... criteria) {

		final Session session = 
				(Session) ENTITY_MANAGER
				.getDelegate();

		final Criteria crit = 
				session.createCriteria(CLASSE);
		
		for (Criterion criterion : criteria) {
			crit.add(criterion);
		}
		
		return crit.list();
	}

	@Override
	public List<T> buscarPorExemplo(T exemplo, String... propriedadesAExcluir) {
		// TODO Auto-generated method stub
		return null;
	}

}
