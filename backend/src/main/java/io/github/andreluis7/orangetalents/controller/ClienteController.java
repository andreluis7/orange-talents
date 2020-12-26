package io.github.andreluis7.orangetalents.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.andreluis7.orangetalents.dto.request.ClienteDTO;
import io.github.andreluis7.orangetalents.dto.response.ClienteResponseDTO;
import io.github.andreluis7.orangetalents.model.Cliente;
import io.github.andreluis7.orangetalents.service.interfaces.ClienteService;

@RestController
@RequestMapping("v1/cadastro")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteResponseDTO> salveCliente(@RequestBody @Valid ClienteDTO cliente) {
		Cliente clienteSalvo = clienteService.salveNovoCliente(cliente);
		URI location = geradorLocation(clienteSalvo.getId());

		return ResponseEntity.created(location).body(clienteSalvo.paraResponse());
	}

	private URI geradorLocation(Long id) {
		Cliente clienteAtualizado = clienteService.busqueClientePeloId(id);
		return ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(clienteAtualizado.getId()).toUri();
	}
}
