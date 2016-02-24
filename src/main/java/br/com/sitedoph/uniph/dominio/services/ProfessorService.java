package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.repositorios.ProfessorRepositorio;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class ProfessorService {

    @Inject
    private ProfessorRepositorio repo;

    public Professor buscarPorId(final Long id) {
        return repo.buscarPorId(id);
    }

    public Professor buscarPorCPF(String cpf) {
        return repo.buscarPorCPF(cpf);
    }

    public List<Professor> buscarTodos() {
        return repo.buscarTodos();
    }

    public void excluir(Professor professor) {
        repo.excluir(professor);
    }

    public Professor salvarOuAtualizar(Professor professor) {
        return repo.salvarOuAtualizar(professor);
    }
}
