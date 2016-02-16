package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.AlunoDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AlunoRepositorio {

    private EntityManager em;
    private AlunoDAO DAO;

    private void criarDAOeEM() {
        em = JPAUtil.getEntityManager();
        DAO = new AlunoDAO(em);
    }

    public Aluno buscarPorId(Long id) {

        criarDAOeEM();

        Aluno u = DAO.buscarPorId(id);

        em.close();

        return u;
    }

    public List<Aluno> buscarTodos() {

        criarDAOeEM();

        List<Aluno> lista = DAO.buscarTodos();

        em.close();

        return lista;
    }

    public void excluir(final Aluno aluno) {

        criarDAOeEM();

        em.getTransaction().begin();

        try {
            DAO.excluir(aluno);
            em.getTransaction().commit();
        } catch (final Exception e) {
            em.getTransaction().rollback();
        }

        em.close();

    }

    public Aluno salvarOuAtualizar(Aluno aluno) {

        criarDAOeEM();

        em.getTransaction().begin();

        try {
            aluno = DAO.salvarOuAtualizar(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }

        return aluno;
    }

    public Aluno buscarPorCPF(String cpf) {

        criarDAOeEM();

        Aluno u = DAO.buscarCPF(cpf);

        em.close();

        return u;
    }

}
