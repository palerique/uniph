package br.com.sitedoph.uniph.aplicacao.managedsbeans;


import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.services.ProfessorService;
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
public class ProfessorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProfessorService professorService;

    private Professor professor = new Professor();
    private List<Professor> professors;

    private Date dataUtilCadastro = new Date();
    private String filtro;

    public void filtrar() {
        this.professors = professorService.filtrarPorPalavraChave(filtro);
    }

    public void salvar() {

        boolean edicao = professor.getId() != null;

        professor.setDataDeCadastro(DateUtils.toCalendar(dataUtilCadastro));

        professorService.salvarOuAtualizar(professor);
        professor = new Professor();
        professors = professorService.buscarTodos();

        FacesMessage msg;
        if (edicao) {
            msg = new FacesMessage("Professor alterado com sucesso!");
        } else {
            msg = new FacesMessage("Professor cadastrado com sucesso!");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void remover(Professor professor) {
        professorService.excluir(professor);
        professors = professorService.buscarTodos();

        FacesMessage msg = new FacesMessage("Professor excluído com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void limpar() {
        this.professor = new Professor();
    }

    public Collection<Professor> getProfessors() {
        if (professors == null) {
            professors = professorService.buscarTodos();
        }

        return professors;
    }

    public Professor getProfessor() {

        if (professor.getDataDeCadastro() != null) {
            dataUtilCadastro = professor.getDataDeCadastro().getTime();
        }

        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Date getDataUtilCadastro() {
        return dataUtilCadastro;
    }

    public void setDataUtilCadastro(Date dataUtilCadastro) {
        this.dataUtilCadastro = dataUtilCadastro;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}