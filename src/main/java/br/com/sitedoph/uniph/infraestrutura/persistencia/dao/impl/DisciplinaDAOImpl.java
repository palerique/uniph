package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.DisciplinaDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAOHibernate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class DisciplinaDAOImpl extends GenericDAOHibernate<Disciplina, Long> implements Serializable, DisciplinaDAO {

    public DisciplinaDAOImpl() {
        super(Disciplina.class);
    }

    @Override
    public Disciplina buscarPorDescricao(String descricao) {

        Disciplina exemplo = new Disciplina();

        exemplo.setDescricao(descricao);

        List<Disciplina> porExemplo = super.buscarPorExemplo(exemplo);

        if (porExemplo != null && !porExemplo.isEmpty()) {
            return porExemplo.get(0);
        } else {
            return null;
        }
    }
}


