package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.TurmaDAO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class TurmaRepositorio {

    @Inject
    private TurmaDAO DAO;

    public Turma buscarPorId(Long id) {
        Turma u = DAO.buscarPorId(id);
        return u;
    }

    public List<Turma> buscarTodos() {
        List<Turma> lista = DAO.buscarTodos();
        return lista;
    }

    public void excluir(final Turma turma) {
        DAO.excluir(turma);
    }

    public Turma salvarOuAtualizar(Turma turma) {
        turma = DAO.salvarOuAtualizar(turma);
        return turma;
    }

    public Turma buscarPorDescricao(String descricao) {
        Turma u = DAO.buscarPorDescricao(descricao);
        return u;
    }

}
