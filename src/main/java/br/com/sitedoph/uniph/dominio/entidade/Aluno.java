package br.com.sitedoph.uniph.dominio.entidade;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno {

	@Id
	@GeneratedValue
	private Long id;

	private String nomeCompleto;
	private String rg;

	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeNascimento;

	private String telefone;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeCadastro;

	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

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

	public String getRg() {

		return rg;
	}

	public void setRg(String rg) {

		this.rg = rg;
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf(String cpf) {

		this.cpf = cpf;
	}

	public Calendar getDataDeNascimento() {

		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {

		this.dataDeNascimento = dataDeNascimento;
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

	public Sexo getSexo() {

		return sexo;
	}

	public void setSexo(Sexo sexo) {

		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Aluno [" + (id != null ? "id=" + id + ", " : "")
				+ (nomeCompleto != null ? "nomeCompleto=" + nomeCompleto + ", " : "")
				+ (rg != null ? "rg=" + rg + ", " : "") + (cpf != null ? "cpf=" + cpf + ", " : "")
				+ (dataDeNascimento != null ? "dataDeNascimento=" + dataDeNascimento.getTime() + ", " : "")
				+ (telefone != null ? "telefone=" + telefone + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (dataDeCadastro != null ? "dataDeCadastro=" + dataDeCadastro.getTime() + ", " : "")
				+ (sexo != null ? "sexo=" + sexo : "") + "]";
	}

}
