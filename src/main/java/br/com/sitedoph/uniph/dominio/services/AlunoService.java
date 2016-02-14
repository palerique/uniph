package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.repositorios.AlunoRepositorio;

import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class AlunoService {

    private final AlunoRepositorio repo = new AlunoRepositorio();

    public Aluno buscarPorId(final Long id) {
        return repo.buscarPorId(id);
    }

    public Aluno buscarPorCPF(String cpf) {
        return repo.buscarPorCPF(cpf);
    }

    public List<Aluno> buscarTodos() {
        return repo.buscarTodos();
    }

    public void excluir(Aluno aluno) {
        repo.excluir(aluno);
    }

    public Aluno salvarOuAtualizar(Aluno aluno) {
        return repo.salvarOuAtualizar(aluno);
    }

}
