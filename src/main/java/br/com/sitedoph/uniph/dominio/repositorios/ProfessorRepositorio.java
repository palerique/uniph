package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Professor;

import java.io.Serializable;
import java.util.List;

public interface ProfessorRepositorio extends Serializable {

    Professor buscarPorId(Long id);

    List<Professor> buscarTodos();

    void excluir(Professor professor);

    Professor salvarOuAtualizar(Professor professor);

    List<Professor> filtrarPorPalavraChave(String filtro);
}
