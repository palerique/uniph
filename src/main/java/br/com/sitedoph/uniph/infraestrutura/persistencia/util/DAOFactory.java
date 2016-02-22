package br.com.sitedoph.uniph.infraestrutura.persistencia.util;

import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.GenericDAOHibernate;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.ParameterizedType;

/**
 * Created by paulohl on 22/02/2016.
 */
public class DAOFactory {

    @Produces
    public GenericDAO create(InjectionPoint injectionPoint) {
        ParameterizedType type = (ParameterizedType) injectionPoint.getType();

        Class classe = (Class) type.getActualTypeArguments()[0];

        return new GenericDAOHibernate(classe);
    }
}