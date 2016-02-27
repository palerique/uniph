package br.com.sitedoph.uniph.dominio.entidades;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Preencha a descrição!")
    private String descricao;

    private String diasDaSemana;
    private String horario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "turma_aluno", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_aluno"))
    private List<Aluno> alunos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "turma_disciplina", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
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
