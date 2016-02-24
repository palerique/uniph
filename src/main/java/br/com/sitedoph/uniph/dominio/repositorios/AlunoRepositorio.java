package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.AlunoDAOImpl;

import javax.inject.Inject;
import java.util.List;

public class AlunoRepositorio {

    @Inject
    private AlunoDAOImpl DAO;

    public Aluno buscarPorId(Long id) {
        Aluno u = DAO.buscarPorId(id);
        return u;
    }

    public List<Aluno> buscarTodos() {
        List<Aluno> lista = DAO.buscarTodos();
        return lista;
    }

    public void excluir(final Aluno aluno) {
        DAO.excluir(aluno);
    }

    public Aluno salvarOuAtualizar(Aluno aluno) {
        aluno = DAO.salvarOuAtualizar(aluno);
        return aluno;
    }

    public Aluno buscarPorCPF(String cpf) {
        Aluno u = DAO.buscarCPF(cpf);
        return u;
    }

}
