package io.github.andreluis7.orangetalents.service.interfaces;

import io.github.andreluis7.orangetalents.dto.request.ClienteDTO;
import io.github.andreluis7.orangetalents.model.Cliente;

public interface ClienteService {

	Cliente salveNovoCliente(ClienteDTO cliente);

	Cliente busqueClientePeloId(Long id);
}
