package io.github.andreluis7.orangetalents.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.andreluis7.orangetalents.repository.ClienteRepository;
import io.github.andreluis7.orangetalents.validation.annotations.EmailUnico;

public class UnicoEmailValidator implements ConstraintValidator<EmailUnico, String> {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
		return !clienteRepository.findByEmail(email).isPresent();
	}
}