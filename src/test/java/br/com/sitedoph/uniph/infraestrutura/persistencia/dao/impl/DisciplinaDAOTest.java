package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.processor.HibernateProcessor;
import org.hibernate.Session;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class DisciplinaDAOTest extends BaseTest {

    @Test
    public void deveFazerCRUDDeDisciplina() {

        EntityManager em = JPAUtil.getEntityManager();
        DisciplinaDAO dao = new DisciplinaDAO(em);

        Disciplina disciplina1 = Fixture.from(Disciplina.class).uses(new HibernateProcessor((Session) em.getDelegate())).gimme("valid");

        Disciplina disciplinaPorDescricao = dao.buscarPorDescricao(disciplina1.getDescricao());
        em.getTransaction().begin();
        if (disciplinaPorDescricao != null) {
            dao.excluir(disciplinaPorDescricao);
        }
        em.getTransaction().commit();

        em.getTransaction().begin();
        disciplina1 = dao.salvarOuAtualizar(disciplina1);
        em.getTransaction().commit();

        assertReflectionEquals(disciplina1, dao.buscarPorId(disciplina1.getId()));

        for (Disciplina disciplina : dao.buscarTodos()) {
            System.out.println(disciplina);
        }

        em.close();

    }

}
