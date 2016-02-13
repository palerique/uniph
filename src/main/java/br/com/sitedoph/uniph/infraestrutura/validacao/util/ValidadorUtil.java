package br.com.sitedoph.uniph.infraestrutura.validacao.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidadorUtil {

	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	public static Validator getValidator() {
		return factory.getValidator();
	}

}
