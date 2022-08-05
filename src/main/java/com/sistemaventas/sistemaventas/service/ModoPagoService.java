package com.sistemaventas.sistemaventas.service;

import com.sistemaventas.sistemaventas.entity.ModoPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ModoPagoService {

    public Iterable<ModoPago> findAll();

    public Page<ModoPago> findAll(Pageable pageable);

    public Optional<ModoPago> findById(int id);

    public ModoPago save(ModoPago modoPago);

    public void deleteById(int id);


}
