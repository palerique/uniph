package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.tests.BaseTest;

public class DisciplinaDAOImplTest extends BaseTest {

//    @Test
//    public void deveFazerCRUDDeDisciplina() {
//
//        EntityManager em = JPAProducer.getEntityManager(null);
//        DisciplinaDAOImpl dao = new DisciplinaDAOImpl(em);
//
//        Disciplina disciplina1 = Fixture.from(Disciplina.class).uses(new HibernateProcessor((Session) em.getDelegate())).gimme("valid");
//
//        Disciplina disciplinaPorDescricao = dao.buscarPorDescricao(disciplina1.getDescricao());
//        em.getTransaction().begin();
//        if (disciplinaPorDescricao != null) {
//            dao.excluir(disciplinaPorDescricao);
//        }
//        em.getTransaction().commit();
//
//        em.getTransaction().begin();
//        disciplina1 = dao.salvarOuAtualizar(disciplina1);
//        em.getTransaction().commit();
//
//        assertReflectionEquals(disciplina1, dao.buscarPorId(disciplina1.getId()));
//
//        dao.buscarTodos().forEach(System.out::println);
//
//        em.close();
//
//    }

}
