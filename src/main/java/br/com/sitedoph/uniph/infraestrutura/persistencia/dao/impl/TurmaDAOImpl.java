package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAOHibernate;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.TurmaDAO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class TurmaDAOImpl extends GenericDAOHibernate<Turma, Long> implements Serializable, TurmaDAO {

    public TurmaDAOImpl() {
        super(Turma.class);
    }

    @Override
    public Turma buscarPorDescricao(String descricao) {

        Turma exemplo = new Turma();

        exemplo.setDescricao(descricao);

        List<Turma> porExemplo = buscarPorExemplo(exemplo);

        if (porExemplo != null && !porExemplo.isEmpty()) {
            return porExemplo.get(0);
        } else {
            return null;
        }
    }
}
