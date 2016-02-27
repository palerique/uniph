package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.time.DateUtils;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.services.AlunoService;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoService alunoService;

	private Aluno aluno = new Aluno();

	private Date dataUtilNascimento;
	private Date dataUtilCadastro = new Date();

	private List<Aluno> alunos;

	public void salvar() {

		boolean edicao = aluno.getId() != null;

		aluno.setDataDeCadastro(DateUtils.toCalendar(dataUtilCadastro));
		aluno.setDataDeNascimento(DateUtils.toCalendar(dataUtilNascimento));

		alunoService.salvarOuAtualizar(aluno);
		aluno = new Aluno();
		this.alunos = alunoService.buscarTodos();

		FacesMessage msg;
		if (edicao) {
			msg = new FacesMessage("Aluno alterado com sucesso!");
		} else {
			msg = new FacesMessage("Aluno cadastrado com sucesso!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void limpar() {
		this.aluno = new Aluno();
		this.dataUtilNascimento = null;
	}

	public Aluno getAluno() {

		if (aluno.getDataDeCadastro() != null) {
			dataUtilCadastro = aluno.getDataDeCadastro().getTime();
		}

		if (aluno.getDataDeNascimento() != null) {
			dataUtilNascimento = aluno.getDataDeNascimento().getTime();
		}

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

	public List<Aluno> getAlunos() {

		if (alunos == null) {
			alunos = alunoService.buscarTodos();
		}

		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}