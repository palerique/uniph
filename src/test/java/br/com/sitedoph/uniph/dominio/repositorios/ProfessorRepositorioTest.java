package br.com.sitedoph.uniph.dominio.repositorios;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Professor;

public class ProfessorRepositorioTest {

	private static final String CPF = "999.999.999-99";

	@Test
	public void deveFuncionarORepositorio() {

		ProfessorRepositorio repo = new ProfessorRepositorio();

		Professor buscarPorCPF = repo.buscarPorCPF(CPF);

		if (buscarPorCPF != null) {
			repo.excluir(buscarPorCPF);
		}

		Professor professor = new Professor();

		professor.setCpf(CPF);

		professor = repo.salvarOuAtualizar(professor);

		Professor buscarPorId = repo.buscarPorId(professor.getId());

		Assert.assertEquals(professor.getCpf(), buscarPorId.getCpf());
	}

}
