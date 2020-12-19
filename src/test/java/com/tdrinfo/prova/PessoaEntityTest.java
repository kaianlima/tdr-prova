package com.tdrinfo.prova;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tdrinfo.prova.entity.Pessoa;

class PessoaEntityTest {

	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	private static Pessoa pessoa = null;

	@BeforeAll
	static void testCreatePessoa() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();

		String nome = "João";
		LocalDate nascimento = LocalDate.of(2010, 8, 2);
		String cpf = "525.991.592-53";

		pessoa = new Pessoa(nome, nascimento, cpf);
	}

	@AfterAll
	static void close() {
		validatorFactory.close();
	}

	// Caso de Sucesso
	
	@Test
	void testPessoa() {
		String nome = "João";
		LocalDate nascimento = LocalDate.of(2010, 8, 2);
		String cpf = "525.991.592-53";
		pessoa = new Pessoa(nome, nascimento, cpf);

		assertNotNull(pessoa);
	}

	// Casos de Erros

	@Test
	void testNomeInvalido() {
		String nome = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras gravida interdum ipsum vel volutpat. "
				+ "Praesent et maximus erat. Aliquam scelerisque dolor sit amet est consequat ornare eu cursus urna. "
				+ "Etiam imperdiet at nunc id cursus. Nullam ultrices metus ac odio vulputate condimentum sit amet ut lacus.";
		LocalDate nascimento = LocalDate.of(2021, 8, 2);
		String cpf = "123.456.789-01";
		Pessoa pessoaInvalida = new Pessoa(nome, nascimento, cpf);

		Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoaInvalida);

		assertFalse(violations.isEmpty());
	}

	@Test
	void testNascimentoInvalido() {
		String nome = "João";
		LocalDate nascimento = LocalDate.of(2021, 8, 2);
		String cpf = "123.456.789-01";
		Pessoa pessoaInvalida = new Pessoa(nome, nascimento, cpf);

		Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoaInvalida);

		assertFalse(violations.isEmpty());
	}

	@Test
	void testCpfInvalido() {
		String nome = "João";
		LocalDate nascimento = LocalDate.of(2010, 8, 2);
		String cpf = "123.456.789-01";
		Pessoa pessoaInvalida = new Pessoa(nome, nascimento, cpf);

		Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoaInvalida);

		assertFalse(violations.isEmpty());
	}

}
