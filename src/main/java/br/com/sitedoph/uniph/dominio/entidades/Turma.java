package br.com.sitedoph.uniph.dominio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;
    private String diasDaSemana;
    private String horario;

    @ManyToMany
    private List<Aluno> alunos;

    @ManyToMany
    private List<Disciplina> disciplinas;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public String getDiasDaSemana() {

        return diasDaSemana;
    }

    public void setDiasDaSemana(String diasDaSemana) {

        this.diasDaSemana = diasDaSemana;
    }

    public String getHorario() {

        return horario;
    }

    public void setHorario(String horario) {

        this.horario = horario;
    }

    public List<Aluno> getAlunos() {

        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {

        this.alunos = alunos;
    }

    public List<Disciplina> getDisciplinas() {

        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {

        this.disciplinas = disciplinas;
    }

}
