package io.github.andreluis7.orangetalents.repository;

import io.github.andreluis7.orangetalents.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
