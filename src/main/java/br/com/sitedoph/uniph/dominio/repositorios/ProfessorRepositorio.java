package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.ProfessorDAO;

import javax.inject.Inject;
import java.util.List;

public class ProfessorRepositorio {

    @Inject
    private ProfessorDAO DAO;

    public Professor buscarPorId(Long id) {
        Professor u = DAO.buscarPorId(id);
        return u;
    }

    public List<Professor> buscarTodos() {
        List<Professor> lista = DAO.buscarTodos();
        return lista;
    }

    public void excluir(final Professor professor) {
        DAO.excluir(professor);
    }

    public Professor salvarOuAtualizar(Professor professor) {
        professor = DAO.salvarOuAtualizar(professor);
        return professor;
    }

    public Professor buscarPorCPF(String cpf) {
        Professor u = DAO.buscarCPF(cpf);
        return u;
    }

}
