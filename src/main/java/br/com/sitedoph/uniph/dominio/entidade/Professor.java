package br.com.sitedoph.uniph.dominio.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PROFESSOR")
public class Professor {

	@Id
	@GeneratedValue
	@Column(name = "MATRICULA")
	private Long id;

	@Column(name = "NOME_COMPLETO")
	private String nomeCompleto;
	@Column(name = "CPF")
	private String cpf;

	@Column(name = "DT_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeCadastro;

	@Column(name = "TELEFONE")
	private String telefone;
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CURRICULO")
	private String curriculo;

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

	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
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

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

}
