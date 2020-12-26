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

	@NotBlank(message = " {campo.nome.obrigatorio}")
	private String nome;

	@NotBlank(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	@ValorUnico(domainClass = Cliente.class, fieldName = "cpf", message = "{campo.cpf.repetido}")
	private String cpf;

	@NotBlank(message = "{campo.email.obrigatorio}")
	@Email(message = "{campo.email.invalido}")
	@ValorUnico(domainClass = Cliente.class, fieldName = "email", message = "{campo.email.repetido}")
	private String email;

	@NotNull(message = "{campo.data-nascimento.obrigatorio}")
	@Past(message = "{campo.data-nascimento.invalida}")
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
