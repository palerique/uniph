package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.repositorios.DisciplinaRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class DisciplinaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DisciplinaRepositorio repo;

    public Disciplina buscarPorId(Long id) {
        return repo.buscarPorId(id);
    }

    public List<Disciplina> buscarTodos() {
        return repo.buscarTodos();
    }

    @Transacional
    public void excluir(Disciplina disciplina) {
        repo.excluir(disciplina);
    }

    @Transacional
    public Disciplina salvarOuAtualizar(Disciplina disciplina) {
        return repo.salvarOuAtualizar(disciplina);
    }

    public List<Disciplina> filtrarPorPalavraChave(String filtro) {
        return repo.filtrarPorPalavraChave(filtro);
    }
}
