package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidade.Disciplina;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class DisciplinaDAOTest extends BaseTest {

    @Test
    public void deveFazerCRUDDeDisciplina() {

        EntityManager em = JPAUtil.getEntityManager();

        DisciplinaDAO dao = new DisciplinaDAO(em);

        Disciplina disciplina1 = Fixture.from(Disciplina.class).gimme(VALID);

        Disciplina disciplinaPorCPF = dao.buscarPorDescricao(disciplina1.getDescricao());

        em.getTransaction().begin();
        if (disciplinaPorCPF != null) {
            dao.excluir(disciplinaPorCPF);
        }
        em.getTransaction().commit();

        em.getTransaction().begin();

        disciplina1 = dao.salvarOuAtualizar(disciplina1);

        em.getTransaction().commit();

        Disciplina buscarPorId = dao.buscarPorId(disciplina1.getId());

//		Assert.assertEquals(disciplina1.getId(), buscarPorId.getId());
//		Assert.assertEquals(disciplina1.getNomeCompleto(), buscarPorId.getNomeCompleto());
//		Assert.assertEquals(disciplina1.getCurrriculo(), buscarPorId.getCurrriculo());
//		Assert.assertEquals(disciplina1.getCpf(), buscarPorId.getCpf());
//		Assert.assertEquals(disciplina1.getDataDeCadastro(), buscarPorId.getDataDeCadastro());
//		Assert.assertEquals(disciplina1.getEmail(), buscarPorId.getEmail());
//		Assert.assertEquals(disciplina1.getTelefone(), buscarPorId.getTelefone());

//        assertThat(buscarPorId, sameInstance(disciplina1));

        assertReflectionEquals(disciplina1, buscarPorId);

        List<Disciplina> buscarTodos = dao.buscarTodos();

        for (Disciplina disciplina : buscarTodos) {
            System.out.println(disciplina);
        }

        em.close();

    }

}
