package br.com.sitedoph.uniph.infraestrutura.persistencia.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAProducer {

    @Produces
    @ApplicationScoped
    public static EntityManagerFactory getFactory() {
        return Persistence.createEntityManagerFactory("uniph");
    }

    @Produces
    @RequestScoped
    public static EntityManager getEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }

    @RequestScoped
    public void fechaEM(@Disposes @Any EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

}
