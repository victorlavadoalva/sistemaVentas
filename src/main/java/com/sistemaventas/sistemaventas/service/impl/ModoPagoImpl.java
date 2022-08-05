package com.sistemaventas.sistemaventas.service.impl;

import com.sistemaventas.sistemaventas.entity.ModoPago;
import com.sistemaventas.sistemaventas.repository.ModoPagoRepositoy;
import com.sistemaventas.sistemaventas.service.ModoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ModoPagoImpl implements ModoPagoService {

    @Autowired
    private ModoPagoRepositoy modoPagoRepositoy;

    @Override
    @Transactional(readOnly = true)
    public Iterable<ModoPago> findAll() {
        return modoPagoRepositoy.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ModoPago> findAll(Pageable pageable) {
        return modoPagoRepositoy.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ModoPago> findById(int id) {
        return modoPagoRepositoy.findById(id);
    }

    @Override
    @Transactional
    public ModoPago save(ModoPago modoPago) {
        return modoPagoRepositoy.save(modoPago);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        modoPagoRepositoy.deleteById(id);
    }
}
