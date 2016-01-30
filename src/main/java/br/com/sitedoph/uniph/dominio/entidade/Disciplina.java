package br.com.sitedoph.uniph.dominio.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Professor professor;

	private String descricao;
	private String cargaHoraria;

}
