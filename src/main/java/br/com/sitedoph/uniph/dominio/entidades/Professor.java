package br.com.sitedoph.uniph.dominio.entidades;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Preencha o nome completo!")
    @Size(min = 5)
    private String nomeCompleto;

    @CPF(message = "CPF inválido")
    private String cpf;
    private String telefone;

    @NotEmpty(message = "Preencha o e-mail!")
    @Email(message = "Endereço de e-mail inválido")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataDeCadastro;

    @Column(length = 5000)
    private String currriculo;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNomeCompleto() {

        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {

        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Calendar getDataDeCadastro() {

        return dataDeCadastro;
    }

    public void setDataDeCadastro(Calendar dataDeCadastro) {

        this.dataDeCadastro = dataDeCadastro;
    }

    public String getCurrriculo() {

        return currriculo;
    }

    public void setCurrriculo(String currriculo) {

        this.currriculo = currriculo;
    }

    @Override
    public String toString() {
        return "Professor [" + (id != null ? "id=" + id + ", " : "")
                + (nomeCompleto != null ? "nomeCompleto=" + nomeCompleto + ", " : "")
                + (cpf != null ? "cpf=" + cpf + ", " : "") + (telefone != null ? "telefone=" + telefone + ", " : "")
                + (email != null ? "email=" + email + ", " : "")
                + (dataDeCadastro != null ? "dataDeCadastro=" + dataDeCadastro.getTime() + ", " : "")
                + (currriculo != null ? "currriculo=" + currriculo : "") + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
