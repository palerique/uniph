package br.com.sitedoph.uniph.infraestrutura.persistencia;

import javax.persistence.EntityManager;

import org.junit.Test;

public class PersistenciaTest {

	@Test
	public void deveCriarOEntityManagerFactoryEEntityManager() {

		EntityManager em = JPAUtil.getEntityManager();
		em.close();

	}

}
