package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ProfessorDAOTest extends BaseTest {

    @Test
    public void deveFazerCRUDDeProfessor() {

        EntityManager em = JPAUtil.getEntityManager();
        ProfessorDAO dao = new ProfessorDAO(em);

        Professor professor1 = Fixture.from(Professor.class).gimme(VALID);

        Professor professorPorCPF = dao.buscarCPF(professor1.getCpf());

        em.getTransaction().begin();
        if (professorPorCPF != null) {
            dao.excluir(professorPorCPF);
        }
        em.getTransaction().commit();

        em.getTransaction().begin();


        professor1 = dao.salvarOuAtualizar(professor1);

        em.getTransaction().commit();

        assertReflectionEquals(professor1, dao.buscarPorId(professor1.getId()));

        for (Professor professor : dao.buscarTodos()) {
            System.out.println(professor);
        }

        em.close();

    }

}
