package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAOHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> CLASSE;

    @Inject
    private EntityManager ENTITY_MANAGER;

    @Inject
    public GenericDAOHibernate(Class<T> classe) {
        CLASSE = classe;
    }

    @Override
    public T salvarOuAtualizar(T entidade) {

        final EntityTransaction transaction = ENTITY_MANAGER.getTransaction();

        transaction.begin();

        try {
            entidade = ENTITY_MANAGER.merge(entidade);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }

        return entidade;
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

        final EntityTransaction transaction = ENTITY_MANAGER.getTransaction();

        transaction.begin();

        try {
            entidade = ENTITY_MANAGER.merge(entidade);
            ENTITY_MANAGER.remove(entidade);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }

    }

    @Override
    public List<T> buscarPorCriteria(Criterion... criteria) {

        final Session session = getHibernateSession();

        final Criteria crit = session.createCriteria(CLASSE);

        for (Criterion criterion : criteria) {
            crit.add(criterion);
        }

        return crit.list();
    }

    private Session getHibernateSession() {
        return (Session) ENTITY_MANAGER.getDelegate();
    }

    @Override
    public List<T> buscarPorExemplo(T exemplo, String... propriedadesAExcluir) {

        final Example example = Example.create(exemplo);

        example.enableLike(MatchMode.ANYWHERE);
        example.excludeZeroes();
        example.ignoreCase();

        for (String prop : propriedadesAExcluir) {
            example.excludeProperty(prop);
        }

        final Session session = getHibernateSession();

        final Criteria criteria = session.createCriteria(CLASSE).add(example);

        return criteria.list();
    }

    @Override
    public EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}
