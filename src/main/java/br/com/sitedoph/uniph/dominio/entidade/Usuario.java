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

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -162222018784333347L;

	/**
	 * The email.
	 */
	@Email(message = "E-mail inválido")
	@NotBlank(message = "É necessário um "
			+ "endereço de e-mail")
	@Column(unique = true)
	private String email;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * The login.
	 */
	@NotBlank(message = "Login obrigatório")
	@Size(min = 3, message = "O login deve ter "
			+ "ao menos 3 caracteres")
	@Column(unique = true)
	private String login;

	/**
	 * The nome completo.
	 */
	@NotBlank(message = "O nome não "
			+ "pode estar vazio")
	@Size(min = 5, message = "O nome deve ter ao "
			+ "menos 5 caracteres")
	private String nomeCompleto;

	/**
	 * The senha.
	 */
	@NotBlank(message = "A senha não pode "
			+ "estar em branco")
	@Size(min = 5, message = "A senha deve"
			+ " ter pelo "
			+ "menos 5 caracteres")
	private String senha;

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(final String email) {

		this.email = email;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {

		this.id = id;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {

		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login
	 *            the new login
	 */
	public void setLogin(final String login) {

		this.login = login;
	}

	/**
	 * Gets the nome completo.
	 *
	 * @return the nome completo
	 */
	public String getNomeCompleto() {

		return nomeCompleto;
	}

	/**
	 * Sets the nome completo.
	 *
	 * @param nomeCompleto
	 *            the new nome completo
	 */
	public void setNomeCompleto(final String nomeCompleto) {

		this.nomeCompleto = nomeCompleto;
	}

	/**
	 * Gets the senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {

		return senha;
	}

	/**
	 * Sets the senha.
	 *
	 * @param senha
	 *            the new senha
	 */
	public void setSenha(final String senha) {

		this.senha = senha;
	}

	@Override
	public String toString() {

		return "Usuario [email=" + email + ", id=" + id + ", login=" + login + ", nomeCompleto=" + nomeCompleto
				+ ", senha=" + senha + "]";
	}

}
