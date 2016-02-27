package br.com.sitedoph.uniph.aplicacao.managedsbeans;


import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.services.AlunoService;
import org.apache.commons.lang.time.DateUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AlunoService alunoService;

    private Aluno aluno = new Aluno();
    private List<Aluno> alunos;

    private Date dataUtilCadastro = new Date();
    private Date dataUtilNascimento;
    private String filtro;

    public void filtrar() {
        this.alunos = alunoService.filtrarPorPalavraChave(filtro);
    }

    public void salvar() {

        boolean edicao = aluno.getId() != null;

        aluno.setDataDeCadastro(DateUtils.toCalendar(dataUtilCadastro));
        aluno.setDataDeNascimento(DateUtils.toCalendar(dataUtilNascimento));

        alunoService.salvarOuAtualizar(aluno);
        aluno = new Aluno();
        alunos = alunoService.buscarTodos();

        FacesMessage msg;
        if (edicao) {
            msg = new FacesMessage("Aluno alterado com sucesso!");
        } else {
            msg = new FacesMessage("Aluno cadastrado com sucesso!");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void remover(Aluno aluno) {
        alunoService.excluir(aluno);
        alunos = alunoService.buscarTodos();

        FacesMessage msg = new FacesMessage("Aluno excluído com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void limpar() {
        this.aluno = new Aluno();
        this.dataUtilNascimento = null;
    }

    public Collection<Aluno> getAlunos() {
        if (alunos == null) {
            alunos = alunoService.buscarTodos();
        }

        return alunos;
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

    public Date getDataUtilCadastro() {
        return dataUtilCadastro;
    }

    public void setDataUtilCadastro(Date dataUtilCadastro) {
        this.dataUtilCadastro = dataUtilCadastro;
    }

    public Date getDataUtilNascimento() {
        return dataUtilNascimento;
    }

    public void setDataUtilNascimento(Date dataUtilNascimento) {
        this.dataUtilNascimento = dataUtilNascimento;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}