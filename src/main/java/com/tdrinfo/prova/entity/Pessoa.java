package com.tdrinfo.prova.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Size(max = 60, message = "O nome pode ter no máximo 60 caracteres")
	@Column(name = "nome")
	private String nome;
	
	@Past(message = "A data precisa ser mais antiga do que a data atual")
	@Column(name = "nascimento")
	private LocalDate nascimento;

	@CPF
	@Column(name = "cpf", length = 15)
	private String cpf;

	public Pessoa() {

	}

	public Pessoa(Long id, String nome, LocalDate nascimento, @CPF String cpf) {
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
	}
	
	public Pessoa(String nome, LocalDate nascimento, @CPF String cpf) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", cpf="
				+ cpf + "]";
	}

}
