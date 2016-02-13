package br.com.sitedoph.uniph.infraestrutura.persistencia;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class PersistenciaTest {

	@Test
	public void deveCriarOEntityManagerFactoryEEntityManager() {

		EntityManager em = JPAUtil.getEntityManager();
		em.close();

	}

	@Test
	public void devePersistirUmAluno() {

		EntityManager em = JPAUtil.getEntityManager();

		Aluno ze = new Aluno();

		ze.setNomeCompleto("José Roberto");
		ze.setCpf("038.865.119-95");
		ze.setDataDeCadastro(Calendar.getInstance());
		ze.setEmail("ze@ze.com");
		ze.setRg("81818181");
		ze.setTelefone("61 81818181");

		em.getTransaction().begin();
		em.persist(ze);
		em.getTransaction().commit();

		// HQL
		Query query = em.createQuery("SELECT a FROM Aluno a");

		List<Aluno> list = query.getResultList();

		for (Aluno a : list) {
			System.out.println(a.getNomeCompleto());
		}

		em.close();

	}

}
