package br.com.sitedoph.uniph.dominio.entidade;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * The Class Usuario.
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = -162222018784333347L;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "É necessário um "
            + "endereço de e-mail")
    @Column(unique = true)
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Login obrigatório")
    @Size(min = 3, message = "O login deve ter "
            + "ao menos 3 caracteres")
    @Column(unique = true)
    private String login;

    @NotBlank(message = "O nome não "
            + "pode estar vazio")
    @Size(min = 5, message = "O nome deve ter ao "
            + "menos 5 caracteres")
    private String nomeCompleto;

    @NotBlank(message = "A senha não pode "
            + "estar em branco")
    @Size(min = 5, message = "A senha deve"
            + " ter pelo "
            + "menos 5 caracteres")
    private String senha;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {

        return "Usuario [email=" + email + ", id=" + id + ", login=" + login + ", nomeCompleto=" + nomeCompleto
                + ", senha=" + senha + "]";
    }

}
