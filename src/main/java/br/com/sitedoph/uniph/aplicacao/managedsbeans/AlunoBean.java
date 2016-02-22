package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import br.com.sitedoph.uniph.aplicacao.util.MensagensUtil;
import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.services.AlunoService;
import br.com.sitedoph.uniph.infraestrutura.util.DataUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by paulohl on 22/02/2016.
 */
@ViewScoped
@ManagedBean
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = -1935308637210420029L;

    private Aluno aluno = new Aluno();
    private Collection<Aluno> alunos;
    private Date dataUtilCadastro = new Date();
    private Date dataUtilNascimento;

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

        AlunoService service = new AlunoService();

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

        alunos = new AlunoService().buscarTodos();

    }

    public Collection<Aluno> getAlunos() {

        if (alunos == null) {

            AlunoService service = new AlunoService();

            alunos = service.buscarTodos();
        }

        return alunos;

    }

    public void remove(Aluno aluno) {

        new AlunoService().excluir(aluno);

        alunos = new AlunoService().buscarTodos();
    }

    public void limparCampos() {

        aluno = new Aluno();

        dataUtilCadastro = new Date();
        dataUtilNascimento = null;

        alunos = new AlunoService().buscarTodos();

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
