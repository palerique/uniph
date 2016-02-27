package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.repositorios.AlunoRepositorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class AlunoDAO extends GenericDAOHibernate<Aluno> implements AlunoRepositorio, Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    @Inject
    public AlunoDAO(EntityManager entityManager) {
        super(Aluno.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Aluno> filtrarPorPalavraChave(String filtro) {

        Query query = entityManager.createQuery(
                "SELECT a FROM Aluno a " +
                        "WHERE " +
                        "lower(a.nomeCompleto) LIKE :filtro OR " +
                        "lower(a.cpf) LIKE :filtro OR " +
                        "lower(a.rg) LIKE :filtro OR " +
                        "lower(a.email) LIKE :filtro OR " +
                        "lower(a.telefone) LIKE :filtro OR " +
                        "lower(a.dataDeCadastro) LIKE :filtro OR " +
                        "lower(a.dataDeNascimento) LIKE :filtro");

        query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

        List<Aluno> resultado = query.getResultList();

        return resultado;
    }
}
