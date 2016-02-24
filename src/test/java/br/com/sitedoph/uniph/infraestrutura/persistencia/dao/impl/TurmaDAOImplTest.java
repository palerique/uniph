package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.tests.BaseTest;

public class TurmaDAOImplTest extends BaseTest {

//    @Test
//    public void deveFazerCRUD() {
//
//        EntityManager em = JPAProducer.getEntityManager(null);
//        TurmaDAOImpl dao = new TurmaDAOImpl(em);
//
//        Turma turma1 = Fixture.from(Turma.class).uses(new HibernateProcessor((Session) em.getDelegate())).gimme("valid");
//
//        Turma turmaPorDescricao = dao.buscarPorDescricao(turma1.getDescricao());
//        em.getTransaction().begin();
//        if (turmaPorDescricao != null) {
//            dao.excluir(turmaPorDescricao);
//        }
//        em.getTransaction().commit();
//
//        em.getTransaction().begin();
//        turma1 = dao.salvarOuAtualizar(turma1);
//        em.getTransaction().commit();
//
//        assertReflectionEquals(turma1, dao.buscarPorId(turma1.getId()));
//
//        dao.buscarTodos().forEach(System.out::println);
//
//        em.close();
//
//    }

}
