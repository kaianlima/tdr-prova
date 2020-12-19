package com.tdrinfo.prova;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.tdrinfo.prova.dao.PessoaRepository;
import com.tdrinfo.prova.entity.Pessoa;

@DataJpaTest
class PessoaRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	private static ValidatorFactory validatorFactory;
	private static Validator validator;
	
	private static Pessoa pessoa = null;

	@BeforeAll
	static void testCreatePessoa() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
	    validator = validatorFactory.getValidator();
	    
		String nome = "João";
		LocalDate nascimento = LocalDate.of(2010, 8, 2);
		String cpf = "075.172.144-11";
		
		pessoa = new Pessoa(nome, nascimento, cpf);
	}
	
	@AfterAll
	static void close() {
	    validatorFactory.close();
	}
	
	@Test
	void injectedComponentsNotNull() {
		assertNotNull(entityManager);
		assertNotNull(pessoaRepository);
	}
	
	// Casos de Sucesso
	
	@Test
	void testSave() {
		assertNotNull(pessoaRepository.save(pessoa));
	}
	
	@Test
	void testFindAll() {
		pessoa = pessoaRepository.save(pessoa);
		
		assertTrue(pessoaRepository.count() > 0);
	}
	
	@Test
	void testFindById() {
		pessoa = pessoaRepository.save(pessoa);
		
		assertNotNull(pessoaRepository.findById(pessoa.getId()));
	}
	
	@Test
	void testFindByNome() {
		pessoa = pessoaRepository.save(pessoa);
		
		assertNotNull(pessoaRepository.findByNome(pessoa.getNome()));
	}
	
	@Test
	void testFindByNascimento() {
		pessoa = pessoaRepository.save(pessoa);
		
		assertNotNull(pessoaRepository.findByNascimento(pessoa.getNascimento()));
	}
	
	@Test
	void testFindByCpf() {
		pessoa = pessoaRepository.save(pessoa);
		
		assertNotNull(pessoaRepository.findByCpf(pessoa.getCpf()));
	}

	// Casos de Erros

	@Test
	void testNascimentoInvalido() {
		String nome = "João";
		LocalDate nascimento = LocalDate.of(2021, 8, 2);
		String cpf = "123.456.789-01";
		
		Pessoa pessoaInvalida = pessoaRepository.save(new Pessoa(nome, nascimento, cpf));
		Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoaInvalida);
		
		assertFalse(violations.isEmpty());
	}
	
	@Test
	void testCpfInvalido() {
		String nome = "João";
		LocalDate nascimento = LocalDate.of(2010, 8, 2);
		String cpf = "123.456.789-01";
		
		Pessoa pessoaInvalida = pessoaRepository.save(new Pessoa(nome, nascimento, cpf));
		Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoaInvalida);
		
		assertFalse(violations.isEmpty());
	}
	
}
