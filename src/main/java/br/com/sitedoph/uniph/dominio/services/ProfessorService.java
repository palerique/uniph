package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.repositorios.ProfessorRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class ProfessorService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProfessorRepositorio repo;

    public Professor buscarPorId(Long id) {
        return repo.buscarPorId(id);
    }

    public List<Professor> buscarTodos() {
        return repo.buscarTodos();
    }

    @Transacional
    public void excluir(Professor professor) {
        repo.excluir(professor);
    }

    @Transacional
    public Professor salvarOuAtualizar(Professor professor) {
        return repo.salvarOuAtualizar(professor);
    }

    public List<Professor> filtrarPorPalavraChave(String filtro) {
        return repo.filtrarPorPalavraChave(filtro);
    }
}
