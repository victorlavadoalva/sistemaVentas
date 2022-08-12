package com.sistemaventas.sistemaventas.service;

import com.sistemaventas.sistemaventas.entity.Factura;
import com.sistemaventas.sistemaventas.entity.ModoPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FacturaService {

    public Iterable<Factura> findAll();

    public Page<Factura> findAll(Pageable pageable);

    public Optional<Factura> findById(int id);

    public Factura save(Factura factura);

    public void deleteById(int id);
}
