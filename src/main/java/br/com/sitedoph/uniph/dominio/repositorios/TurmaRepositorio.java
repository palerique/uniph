package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.TurmaDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by paler on 14/02/2016.
 */
public class TurmaRepositorio {

    private EntityManager em;
    private TurmaDAO DAO;

    private void criarDAOeEM() {
        em = JPAUtil.getEntityManager(null);
        DAO = new TurmaDAO(em);
    }

    public Turma buscarPorId(Long id) {

        criarDAOeEM();

        Turma u = DAO.buscarPorId(id);

        em.close();

        return u;
    }

    public List<Turma> buscarTodos() {

        criarDAOeEM();

        List<Turma> lista = DAO.buscarTodos();

        em.close();

        return lista;
    }

    public void excluir(final Turma turma) {

        criarDAOeEM();

        em.getTransaction().begin();

        try {
            DAO.excluir(turma);
            em.getTransaction().commit();
        } catch (final Exception e) {
            em.getTransaction().rollback();
        }

        em.close();

    }

    public Turma salvarOuAtualizar(Turma turma) {

        criarDAOeEM();

        em.getTransaction().begin();

        try {
            turma = DAO.salvarOuAtualizar(turma);
            em.getTransaction().commit();
		} catch (ConstraintViolationException | PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

        return turma;
    }

    public Turma buscarPorDescricao(String descricao) {

        criarDAOeEM();

        Turma u = DAO.buscarPorDescricao(descricao);

        em.close();

        return u;
    }

}
