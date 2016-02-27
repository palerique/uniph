package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Turma;

import java.io.Serializable;
import java.util.List;

public interface TurmaRepositorio extends Serializable {

    Turma buscarPorId(Long id);

    List<Turma> buscarTodos();

    void excluir(Turma turma);

    Turma salvarOuAtualizar(Turma turma);

    List<Turma> filtrarPorPalavraChave(String filtro);
}
