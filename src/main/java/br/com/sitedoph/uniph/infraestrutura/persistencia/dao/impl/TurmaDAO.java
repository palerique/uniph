package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class TurmaDAO {

    private final GenericDAO<Turma, Long> DAO;

    public TurmaDAO(EntityManager entityManager) {
        DAO = new GenericDAOHibernate<>(entityManager, Turma.class);
    }

    public void excluir(Turma entidade) {
        DAO.excluir(entidade);
    }

    public Turma salvarOuAtualizar(Turma entidade) {
        return DAO.salvarOuAtualizar(entidade);
    }

    public Turma buscarPorId(Long id) {
        return DAO.buscarPorId(id);
    }

    public List<Turma> buscarTodos() {
        return DAO.buscarTodos();
    }


    public Turma buscarPorDescricao(String descricao) {

        Turma exemplo = new Turma();

        exemplo.setDescricao(descricao);

        List<Turma> porExemplo = DAO.buscarPorExemplo(exemplo);

        if (porExemplo != null && !porExemplo.isEmpty()) {
            return porExemplo.get(0);
        } else {
            return null;
        }
    }
}
