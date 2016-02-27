package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.repositorios.AlunoRepositorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class AlunoDAO extends GenericDAOHibernate<Aluno> implements AlunoRepositorio, Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    @Inject
    public AlunoDAO(EntityManager entityManager) {
        super(Aluno.class, entityManager);
        this.entityManager = entityManager;
    }

}
