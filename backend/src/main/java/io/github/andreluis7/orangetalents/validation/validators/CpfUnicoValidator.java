package io.github.andreluis7.orangetalents.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.andreluis7.orangetalents.repository.ClienteRepository;
import io.github.andreluis7.orangetalents.validation.annotations.CpfUnico;

public class CpfUnicoValidator implements ConstraintValidator<CpfUnico, String> {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return !clienteRepository.findByCpf(cpf).isPresent();
    }
}