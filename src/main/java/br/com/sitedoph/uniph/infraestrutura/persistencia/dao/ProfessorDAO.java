package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import br.com.sitedoph.uniph.dominio.entidades.Professor;

/**
 * Created by paulohl on 23/02/2016.
 */
public interface ProfessorDAO extends GenericDAO<Professor, Long> {
    Professor buscarCPF(String cpf);
}
