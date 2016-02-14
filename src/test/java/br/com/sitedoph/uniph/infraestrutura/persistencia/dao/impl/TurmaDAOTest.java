package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.processor.HibernateProcessor;
import org.hibernate.Session;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class TurmaDAOTest extends BaseTest {

    @Test
    public void deveFazerCRUD() {

        EntityManager em = JPAUtil.getEntityManager();
        TurmaDAO dao = new TurmaDAO(em);

        Turma turma1 = Fixture.from(Turma.class).uses(new HibernateProcessor((Session) em.getDelegate())).gimme("valid");

        Turma turmaPorDescricao = dao.buscarPorDescricao(turma1.getDescricao());
        em.getTransaction().begin();
        if (turmaPorDescricao != null) {
            dao.excluir(turmaPorDescricao);
        }
        em.getTransaction().commit();

        em.getTransaction().begin();
        turma1 = dao.salvarOuAtualizar(turma1);
        em.getTransaction().commit();

        assertReflectionEquals(turma1, dao.buscarPorId(turma1.getId()));

        for (Turma turma : dao.buscarTodos()) {
            System.out.println(turma);
        }

        em.close();

    }

}
