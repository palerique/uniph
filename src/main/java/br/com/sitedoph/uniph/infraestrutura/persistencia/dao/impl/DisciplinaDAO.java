package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.repositorios.DisciplinaRepositorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class DisciplinaDAO extends GenericDAOHibernate<Disciplina> implements DisciplinaRepositorio, Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    @Inject
    public DisciplinaDAO(EntityManager entityManager) {
        super(Disciplina.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Disciplina> filtrarPorPalavraChave(String filtro) {

        Query query = entityManager.createQuery(
                "SELECT a FROM Disciplina a " +
                        "WHERE " +
                        "lower(a.cargaHoraria) LIKE :filtro OR " +
                        "lower(a.descricao) LIKE :filtro OR " +
                        "lower(a.professor.nomeCompleto) LIKE :filtro");

        query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

        List<Disciplina> resultado = query.getResultList();

        return resultado;
    }
}
