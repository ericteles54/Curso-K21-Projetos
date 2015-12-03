package br.com.k19.testes;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.k19.modelo.Pessoa;

public class ValidaPessoa {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("Joao");
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Pessoa>> erros = validator.validate(p);
		
		for(ConstraintViolation<Pessoa> error : erros) {
			System.out.println(error);
		}
	}
}
