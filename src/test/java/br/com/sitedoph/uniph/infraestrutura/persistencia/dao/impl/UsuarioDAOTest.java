package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class UsuarioDAOTest extends BaseTest {

    @Test
    public void deveSalvar() {

        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDAO dao = new UsuarioDAO(em);

        Usuario usuario = Fixture.from(Usuario.class).gimme(VALID);

        excluir(em, dao, usuario);

        em.getTransaction().begin();
        usuario = dao.salvarOuAtualizar(usuario);
        em.getTransaction().commit();

        assertReflectionEquals(usuario, dao.buscarPorId(usuario.getId()));

        for (Usuario user : dao.buscarTodos()) {
            System.out.println(user);
        }

        excluir(em, dao, usuario);

        em.close();

    }

    private void excluir(EntityManager em, UsuarioDAO dao, Usuario usuario) {
        Usuario loginESenha;
        loginESenha = dao.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());

        em.getTransaction().begin();
        if (loginESenha != null) {
            dao.excluir(loginESenha);
        }
        em.getTransaction().commit();
    }

}
