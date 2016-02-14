package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class AlunoDAOTest extends BaseTest {

    @Test
    public void deveFazerCRUDDeAluno() {

        EntityManager em = JPAUtil.getEntityManager();
        AlunoDAO dao = new AlunoDAO(em);

        Aluno estudante = Fixture.from(Aluno.class).gimme(VALID);

        Aluno alunoPorCPF = dao.buscarCPF(estudante.getCpf());
        if (alunoPorCPF != null) {
            estudante = alunoPorCPF;
        }

        em.getTransaction().begin();


        estudante = dao.salvarOuAtualizar(estudante);

        em.getTransaction().commit();

        assertReflectionEquals(estudante, dao.buscarPorId(estudante.getId()));

        for (Aluno aluno : dao.buscarTodos()) {
            System.out.println(aluno);
        }

        em.close();

    }

}
