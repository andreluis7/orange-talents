package io.github.andreluis7.orangetalents.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.andreluis7.orangetalents.model.Cliente;
import io.github.andreluis7.orangetalents.validation.annotations.ValorUnico;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O Nome do Cliente é obrigatório.")
	private String nome;

	@NotBlank(message = "O CPF do Cliente é obrigatório.")
	@CPF(message = "Por favor digite um CPF válido.")
	@ValorUnico(domainClass = Cliente.class, fieldName = "cpf", message = "Já existe um cadastro de cliente com esse CPF.")
	private String cpf;

	@NotBlank(message = "O Email do Cliente é obrigatório.")
	@Email(message = "Por favor digite um Email válido.")
	@ValorUnico(domainClass = Cliente.class, fieldName = "email", message = "Já existe um cadastro de cliente com esse Email.")
	private String email;

	@NotNull(message = "Por favor digite uma data de nascimento.")
	@Past(message = "Por favor informe um data válida.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataDeNascimento;

	public ClienteDTO() {
	}

	public ClienteDTO(@NotBlank String nome, @NotBlank @CPF String cpf,
			@NotBlank @Email String email, @NotNull @Past LocalDate dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Cliente paraCliente() {
        return new Cliente(this.nome, this.cpf, this.email, this.dataDeNascimento);
    }

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public boolean verificaTodosOsDadosEstaoCompletos() {
        return this.nome != null && 
        	   this.email != null && !(this.email.isEmpty()) &&
        	   this.cpf != null && !(this.cpf.isEmpty())
                && this.dataDeNascimento != null;
    }

}
