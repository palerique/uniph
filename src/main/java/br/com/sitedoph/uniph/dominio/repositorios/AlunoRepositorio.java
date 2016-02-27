package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;

import java.io.Serializable;
import java.util.List;

public interface AlunoRepositorio extends Serializable {

    Aluno buscarPorId(Long id);

    List<Aluno> buscarTodos();

    void excluir(Aluno aluno);

    Aluno salvarOuAtualizar(Aluno aluno);

    List<Aluno> filtrarPorPalavraChave(String filtro);
}
