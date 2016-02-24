package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import br.com.sitedoph.uniph.dominio.entidades.Turma;

/**
 * Created by paulohl on 23/02/2016.
 */
public interface TurmaDAO extends GenericDAO<Turma, Long> {
    Turma buscarPorDescricao(String descricao);
}
