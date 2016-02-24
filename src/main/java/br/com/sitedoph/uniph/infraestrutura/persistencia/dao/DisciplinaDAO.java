package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;

/**
 * Created by paulohl on 23/02/2016.
 */
public interface DisciplinaDAO extends GenericDAO<Disciplina, Long> {
    Disciplina buscarPorDescricao(String descricao);
}
