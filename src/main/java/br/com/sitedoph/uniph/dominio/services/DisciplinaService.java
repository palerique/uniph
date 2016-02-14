package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.repositorios.DisciplinaRepositorio;

import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class DisciplinaService {

    private final DisciplinaRepositorio repo = new DisciplinaRepositorio();

    public Disciplina buscarPorId(final Long id) {
        return repo.buscarPorId(id);
    }

    public Disciplina buscarPorDescricao(String descricao) {
        return repo.buscarPorDescricao(descricao);
    }

    public List<Disciplina> buscarTodos() {
        return repo.buscarTodos();
    }

    public void excluir(Disciplina disciplina) {
        repo.excluir(disciplina);
    }

    public Disciplina salvarOuAtualizar(Disciplina disciplina) {
        return repo.salvarOuAtualizar(disciplina);
    }

}
