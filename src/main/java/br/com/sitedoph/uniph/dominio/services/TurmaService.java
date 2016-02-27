package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.dominio.repositorios.TurmaRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class TurmaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TurmaRepositorio repo;

    public Turma buscarPorId(final Long id) {
        return repo.buscarPorId(id);
    }

    public List<Turma> buscarTodos() {
        return repo.buscarTodos();
    }

    @Transacional
    public void excluir(Turma turma) {
        repo.excluir(turma);
    }

    @Transacional
    public Turma salvarOuAtualizar(Turma turma) {
        return repo.salvarOuAtualizar(turma);
    }

    public List<Turma> filtrarPorPalavraChave(String filtro) {
        return repo.filtrarPorPalavraChave(filtro);
    }
}
