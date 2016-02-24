package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.AlunoDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAOHibernate;

import java.io.Serializable;
import java.util.List;

public class AlunoDAOImpl extends GenericDAOHibernate<Aluno, Long> implements Serializable, AlunoDAO {

    public AlunoDAOImpl() {
        super(Aluno.class);
    }

    @Override
    public Aluno buscarCPF(String cpf) {

        Aluno exemplo = new Aluno();

        exemplo.setCpf(cpf);

        List<Aluno> porExemplo = buscarPorExemplo(exemplo);

        if (porExemplo != null && !porExemplo.isEmpty()) {
            return porExemplo.get(0);
        } else {
            return null;
        }
    }

}
