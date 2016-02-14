package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by paler on 14/02/2016.
 */
public class UsuarioServiceTest extends BaseTest {

    @Test
    public void deveFuncionarOService() {

        UsuarioService service = new UsuarioService();

        Usuario usuario = Fixture.from(Usuario.class).gimme(VALID);

        Usuario buscarPorLoginESenha = service.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());

        if (buscarPorLoginESenha != null) {
            usuario = buscarPorLoginESenha;
        }

        usuario = service.salvarOuAtualizar(usuario);

        assertReflectionEquals(usuario, service.buscarPorId(usuario.getId()));

        service.excluir(usuario);

        for (Usuario usuario1 : service.buscarTodos()) {
            System.out.println(usuario1);
        }

    }
}