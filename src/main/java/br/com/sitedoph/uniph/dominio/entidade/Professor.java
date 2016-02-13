package br.com.sitedoph.uniph.dominio.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Professor {

	@Id
	@GeneratedValue
	private Long id;

	private String nomeCompleto;

	private String cpf;
	private String telefone;

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



}
