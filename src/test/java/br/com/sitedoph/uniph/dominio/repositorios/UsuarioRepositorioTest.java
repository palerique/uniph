package br.com.sitedoph.uniph.dominio.repositorios;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;

public class UsuarioRepositorioTest {

	private static final String LOGIN = "LOGAN";
	private static final String SENHA = "SENHAM";

	@Test
	public void deveFuncionarORepositorio() {

		UsuarioRepositorio repo = new UsuarioRepositorio();

		Usuario buscarPorLoginESenha = repo.buscarPorLoginESenha(LOGIN, SENHA);

		if (buscarPorLoginESenha != null) {
			repo.excluir(buscarPorLoginESenha);
		}

		Usuario usuario = new Usuario();

		usuario.setEmail("ph@sitedoph.com.br");
		usuario.setNomeCompleto("Paulo Henrique");
		usuario.setLogin(LOGIN);
		usuario.setSenha(SENHA);

		usuario = repo.salvarOuAtualizar(usuario);

		Usuario buscarPorId = repo.buscarPorId(usuario.getId());

		Assert.assertEquals(usuario.getLogin(), buscarPorId.getLogin());
		Assert.assertEquals(usuario.getSenha(), buscarPorId.getSenha());
	}

}
