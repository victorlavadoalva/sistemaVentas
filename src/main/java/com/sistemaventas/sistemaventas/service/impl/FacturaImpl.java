package com.sistemaventas.sistemaventas.service.impl;

import com.sistemaventas.sistemaventas.entity.Factura;
import com.sistemaventas.sistemaventas.repository.FacturaRepository;
import com.sistemaventas.sistemaventas.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FacturaImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Factura> findAll(Pageable pageable) {
        return facturaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Factura> findById(int id) {
        return facturaRepository.findById(id);
    }

    @Override
    @Transactional
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        facturaRepository.deleteById(id);
    }
}
