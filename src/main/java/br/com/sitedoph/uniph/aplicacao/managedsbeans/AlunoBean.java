package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno = new Aluno();

	private Date dataUtilNascimento;
	private Date dataUtilCadastro;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Date getDataUtilNascimento() {
		return dataUtilNascimento;
	}

	public void setDataUtilNascimento(Date dataUtilNascimento) {
		this.dataUtilNascimento = dataUtilNascimento;
	}

	public Date getDataUtilCadastro() {
		return dataUtilCadastro;
	}

	public void setDataUtilCadastro(Date dataUtilCadastro) {
		this.dataUtilCadastro = dataUtilCadastro;
	}

}