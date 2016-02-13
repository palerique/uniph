package br.com.sitedoph.uniph.dominio.repositorios;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;

public class AlunoRepositorioTest {

	private static final String CPF = "038.865.119-95";

	@Test
	public void deveFuncionarORepositorio() {

		AlunoRepositorio repo = new AlunoRepositorio();

		Aluno buscarPorCPF = repo.buscarPorCPF(CPF);

		if (buscarPorCPF != null) {
			repo.excluir(buscarPorCPF);
		}

		Aluno aluno = new Aluno();

		aluno.setCpf(CPF);

		aluno = repo.salvarOuAtualizar(aluno);

		Aluno buscarPorId = repo.buscarPorId(aluno.getId());

		Assert.assertEquals(aluno.getCpf(), buscarPorId.getCpf());
	}

}
