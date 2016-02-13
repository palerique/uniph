package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;

public class ProfessorDAOTest {

	private String CPF = "999.999.999-99";

	@Test
	public void deveFazerCRUDDeProfessor() {

		EntityManager em = JPAUtil.getEntityManager();

		ProfessorDAO dao = new ProfessorDAO(em);

		Professor professorPorCPF = dao.buscarCPF(CPF);

		em.getTransaction().begin();
		if (professorPorCPF != null) {
			dao.excluir(professorPorCPF);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();

		Professor ph = new Professor();

		ph.setEmail("ph@ph.com");
		ph.setNomeCompleto("ph lerbach");
		ph.setCpf(CPF);
		ph.setCurrriculo(CPF);
		ph.setDataDeCadastro(Calendar.getInstance());
		ph.setTelefone(CPF);

		ph = dao.salvarOuAtualizar(ph);

		em.getTransaction().commit();

		Professor buscarPorId = dao.buscarPorId(ph.getId());

		Assert.assertEquals(ph.getId(), buscarPorId.getId());
		Assert.assertEquals(ph.getNomeCompleto(), buscarPorId.getNomeCompleto());
		Assert.assertEquals(ph.getCurrriculo(), buscarPorId.getCurrriculo());
		Assert.assertEquals(ph.getCpf(), buscarPorId.getCpf());
		Assert.assertEquals(ph.getDataDeCadastro(), buscarPorId.getDataDeCadastro());
		Assert.assertEquals(ph.getEmail(), buscarPorId.getEmail());
		Assert.assertEquals(ph.getTelefone(), buscarPorId.getTelefone());

		List<Professor> buscarTodos = dao.buscarTodos();

		for (Professor professor : buscarTodos) {
			System.out.println(professor);
		}

		em.close();

	}

}
