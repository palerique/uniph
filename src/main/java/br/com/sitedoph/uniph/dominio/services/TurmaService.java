package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.dominio.repositorios.TurmaRepositorio;

import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class TurmaService {

    private final TurmaRepositorio repo = new TurmaRepositorio();

    public Turma buscarPorId(final Long id) {
        return repo.buscarPorId(id);
    }

    public Turma buscarPorDescricao(String descricao) {
        return repo.buscarPorDescricao(descricao);
    }

    public List<Turma> buscarTodos() {
        return repo.buscarTodos();
    }

    public void excluir(Turma turma) {
        repo.excluir(turma);
    }

    public Turma salvarOuAtualizar(Turma turma) {
        return repo.salvarOuAtualizar(turma);
    }

}
