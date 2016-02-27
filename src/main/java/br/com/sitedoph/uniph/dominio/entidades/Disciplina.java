package br.com.sitedoph.uniph.dominio.entidades;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Preencha a descrição!")
    private String descricao;

    @ManyToOne
    private Professor professor;

    private String cargaHoraria;

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public Professor getProfessor() {

        return professor;
    }

    public void setProfessor(Professor professor) {

        this.professor = professor;
    }

    public String getCargaHoraria() {

        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {

        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {

        return "Disciplina [id=" + id + ", descricao=" + descricao + ", professor=" + professor + ", cargaHoraria=" + cargaHoraria + "]";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
