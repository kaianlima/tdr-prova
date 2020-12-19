package com.tdrinfo.prova.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tdrinfo.prova.entity.Pessoa;

@RepositoryRestResource(path = "pessoas")
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByNome(String nome);
	List<Pessoa> findByNascimento(LocalDate nascimento);
	Pessoa findByCpf(String cpf);
}
