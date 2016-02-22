package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class UsuarioDAOTest extends BaseTest {

    @Test
    public void deveSalvar() {

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = Fixture.from(Usuario.class).gimme(VALID);

        excluir(dao, usuario);

        usuario = dao.salvarOuAtualizar(usuario);

        assertReflectionEquals(usuario, dao.buscarPorId(usuario.getId()));

        dao.buscarTodos().forEach(System.out::println);

        excluir(dao, usuario);

    }

    private void excluir(UsuarioDAO dao, Usuario usuario) {
        Usuario loginESenha;
        loginESenha = dao.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());

        if (loginESenha != null) {
            dao.excluir(loginESenha);
        }
    }

}
