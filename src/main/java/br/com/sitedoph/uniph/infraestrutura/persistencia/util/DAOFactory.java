package br.com.sitedoph.uniph.infraestrutura.persistencia.util;

import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.GenericDAOHibernate;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

/**
 * Created by paulohl on 24/02/2016.
 */
public class DAOFactory {

    @Inject
    private EntityManager entityManager;

    @Produces
    public GenericDAOHibernate create(InjectionPoint injectionPoint) {
        ParameterizedType type = (ParameterizedType) injectionPoint.getType();
        Class classe = (Class) type.getActualTypeArguments()[0];
        return new GenericDAOHibernate(classe, entityManager);
    }
}
