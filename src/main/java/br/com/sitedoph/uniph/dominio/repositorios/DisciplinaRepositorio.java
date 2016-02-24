package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.DisciplinaDAO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class DisciplinaRepositorio {

    @Inject
    private DisciplinaDAO DAO;


    public Disciplina buscarPorId(Long id) {
        Disciplina u = DAO.buscarPorId(id);
        return u;
    }

    public List<Disciplina> buscarTodos() {
        List<Disciplina> lista = DAO.buscarTodos();
        return lista;
    }

    public void excluir(final Disciplina disciplina) {
        DAO.excluir(disciplina);
    }

    public Disciplina salvarOuAtualizar(Disciplina disciplina) {
        disciplina = DAO.salvarOuAtualizar(disciplina);
        return disciplina;
    }

    public Disciplina buscarPorDescricao(String descricao) {
        Disciplina u = DAO.buscarPorDescricao(descricao);
        return u;
    }

}
