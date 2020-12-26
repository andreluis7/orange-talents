package io.github.andreluis7.orangetalents.service.implementations;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import io.github.andreluis7.orangetalents.dto.request.ClienteDTO;
import io.github.andreluis7.orangetalents.exception.RecursoNaoEncontradoException;
import io.github.andreluis7.orangetalents.model.Cliente;
import io.github.andreluis7.orangetalents.repository.ClienteRepository;
import io.github.andreluis7.orangetalents.service.interfaces.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
    @Override
    public Cliente salveNovoCliente(ClienteDTO clienteDTO) {
        Assert.isTrue(clienteDTO.verificaTodosOsDadosEstaoCompletos(), "Todos os dados do cliente devem ser informados");
        Cliente cliente = clienteDTO.paraCliente();
        return clienteRepository.save(cliente);
    }
	
	@Override
    public Cliente busqueClientePeloId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElseThrow(() -> new RecursoNaoEncontradoException("Não existe cliente cadastrado com o ID: " + id));
    }
}
