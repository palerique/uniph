package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAOHibernate;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.ProfessorDAO;

import java.io.Serializable;
import java.util.List;

public class ProfessorDAOImpl extends GenericDAOHibernate<Professor, Long> implements Serializable, ProfessorDAO {


    public ProfessorDAOImpl() {
        super(Professor.class);
    }

    @Override
    public Professor buscarCPF(String cpf) {

        Professor exemplo = new Professor();

        exemplo.setCpf(cpf);

        List<Professor> porExemplo = super.buscarPorExemplo(exemplo);

        if (porExemplo != null && !porExemplo.isEmpty()) {
            return porExemplo.get(0);
        } else {
            return null;
        }
    }

}
