package br.com.sitedoph.uniph.aplicacao.managedsbeans;


import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.dominio.services.AlunoService;
import br.com.sitedoph.uniph.dominio.services.DisciplinaService;
import br.com.sitedoph.uniph.dominio.services.TurmaService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Named
@ViewScoped
public class TurmaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TurmaService turmaService;

    @Inject
    private AlunoService alunoService;

    @Inject
    private DisciplinaService disciplinaService;

    private Turma turma = new Turma();

    private List<Turma> turmas;
    private String filtro;
    private Collection<Aluno> alunos;
    private Collection<Disciplina> disciplinas;

    public void filtrar() {
        this.turmas = turmaService.filtrarPorPalavraChave(filtro);
    }

    public void salvar() {

        boolean edicao = turma.getId() != null;

        turmaService.salvarOuAtualizar(turma);
        turma = new Turma();
        turmas = turmaService.buscarTodos();

        FacesMessage msg;
        if (edicao) {
            msg = new FacesMessage("Turma alterada com sucesso!");
        } else {
            msg = new FacesMessage("Turma cadastrada com sucesso!");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void remover(Turma turma) {
        turmaService.excluir(turma);
        turmas = turmaService.buscarTodos();

        FacesMessage msg = new FacesMessage("Turma excluída com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void limpar() {
        this.turma = new Turma();
    }

    public Collection<Turma> getTurmas() {
        if (turmas == null) {
            turmas = turmaService.buscarTodos();
        }

        return turmas;
    }

    public Turma getTurma() {

        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Collection<Aluno> getAlunos() {

        if (alunos == null) {
            alunos = alunoService.buscarTodos();
        }

        return alunos;
    }

    public Collection<Disciplina> getDisciplinas() {

        if (disciplinas == null) {
            disciplinas = disciplinaService.buscarTodos();
        }

        return disciplinas;
    }

}