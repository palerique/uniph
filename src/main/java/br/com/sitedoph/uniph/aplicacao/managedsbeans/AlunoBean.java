package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import br.com.sitedoph.uniph.aplicacao.util.MensagensUtil;
import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.services.AlunoService;
import br.com.sitedoph.uniph.infraestrutura.util.DataUtil;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by paulohl on 22/02/2016.
 */
@ViewScoped
@Named
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = -1935308637210420029L;

    private Aluno aluno = new Aluno();
    private Collection<Aluno> alunos;
    private Date dataUtilCadastro = new Date();
    private Date dataUtilNascimento;

    @Inject
    private AlunoService service;

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

    public void grava() {

        aluno.setDataDeCadastro(DataUtil.converteDataUtilCalendar(dataUtilCadastro));
        aluno.setDataDeNascimento(DataUtil.converteDataUtilCalendar(dataUtilNascimento));

        try {
            service.salvarOuAtualizar(aluno);

            MensagensUtil.info("Aluno Cadastrado com Sucesso");

            aluno = new Aluno();
            dataUtilCadastro = new Date();
            dataUtilNascimento = null;

        } catch (Exception e) {

            e.printStackTrace();

            if (e.getCause() instanceof ConstraintViolationException) {
                MensagensUtil.adicionarMensagensDeValidacao((ConstraintViolationException) e.getCause());
            } else if (e.getCause() instanceof javax.persistence.PersistenceException) {
                MensagensUtil.erro("Não foi possível persistir o aluno!");
            } else {
                throw e;
            }

        }

        alunos = service.buscarTodos();

    }

    public Collection<Aluno> getAlunos() {

        if (alunos == null) {

            alunos = service.buscarTodos();
        }

        return alunos;

    }

    public void remove(Aluno aluno) {

        service.excluir(aluno);

        alunos = service.buscarTodos();
    }

    public void limparCampos() {

        aluno = new Aluno();

        dataUtilCadastro = new Date();
        dataUtilNascimento = null;

        alunos = service.buscarTodos();

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

}
