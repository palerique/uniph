package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class UsuarioRepositorioTest extends BaseTest {

    @Test
    public void deveFuncionarORepositorio() {

        UsuarioRepositorio repo = new UsuarioRepositorio();

        Usuario usuario = Fixture.from(Usuario.class).gimme(VALID);

        Usuario buscarPorLoginESenha = repo.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());

        if (buscarPorLoginESenha != null) {
            usuario = buscarPorLoginESenha;
        }

        usuario = repo.salvarOuAtualizar(usuario);

        assertReflectionEquals(usuario, repo.buscarPorId(usuario.getId()));

        repo.excluir(usuario);

        repo.buscarTodos().forEach(System.out::println);

    }

}
