package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.dominio.entidade.Sexo;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class AlunoDAOTest {

	private String CPF = "038.865.119-95";

	@Test
	public void deveFazerCRUDDeAluno() {

		EntityManager em = JPAUtil.getEntityManager();

		AlunoDAO dao = new AlunoDAO(em);

		Aluno alunoPorCPF = dao.buscarCPF(CPF);

		em.getTransaction().begin();
		if (alunoPorCPF != null) {
			dao.excluir(alunoPorCPF);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();

		Aluno danilo = new Aluno();

		danilo.setEmail("danilo@danilo.com");
		danilo.setNomeCompleto("danilo Gregório");
		danilo.setCpf(CPF);
		danilo.setRg(CPF);
		danilo.setDataDeNascimento(Calendar.getInstance());
		danilo.setDataDeCadastro(Calendar.getInstance());
		danilo.setTelefone(CPF);
		danilo.setSexo(Sexo.MASCULINO);

		danilo = dao.salvarOuAtualizar(danilo);

		em.getTransaction().commit();

		Aluno buscarPorId = dao.buscarPorId(danilo.getId());

		Assert.assertEquals(danilo.getId(), buscarPorId.getId());
		Assert.assertEquals(danilo.getNomeCompleto(), buscarPorId.getNomeCompleto());
		Assert.assertEquals(danilo.getRg(), buscarPorId.getRg());
		Assert.assertEquals(danilo.getCpf(), buscarPorId.getCpf());
		Assert.assertEquals(danilo.getDataDeCadastro(), buscarPorId.getDataDeCadastro());
		Assert.assertEquals(danilo.getDataDeNascimento(), buscarPorId.getDataDeNascimento());
		Assert.assertEquals(danilo.getEmail(), buscarPorId.getEmail());
		Assert.assertEquals(danilo.getTelefone(), buscarPorId.getTelefone());
		Assert.assertEquals(danilo.getSexo(), buscarPorId.getSexo());

		List<Aluno> buscarTodos = dao.buscarTodos();

		for (Aluno aluno : buscarTodos) {
			System.out.println(aluno);
		}

		em.close();

	}

}
