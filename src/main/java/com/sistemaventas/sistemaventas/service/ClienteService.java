package com.sistemaventas.sistemaventas.service;

import com.sistemaventas.sistemaventas.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClienteService {

    public Iterable<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public Optional<Cliente> findById(int id);

    public Cliente save(Cliente cliente);

    public void deleteById(int id);

}
