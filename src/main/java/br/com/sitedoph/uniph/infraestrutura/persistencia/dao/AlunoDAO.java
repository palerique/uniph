package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;

/**
 * Created by paulohl on 23/02/2016.
 */
public interface AlunoDAO extends GenericDAO<Aluno, Long> {
    Aluno buscarCPF(String cpf);
}
