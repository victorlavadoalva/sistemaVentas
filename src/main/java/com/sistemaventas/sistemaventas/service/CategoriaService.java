package com.sistemaventas.sistemaventas.service;

import com.sistemaventas.sistemaventas.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoriaService {

    public Iterable<Categoria> findAll();

    public Page<Categoria> findAll(Pageable pageable);

    public Optional<Categoria> findById(int id);

    public Categoria save(Categoria categoria);

    public void deleteById(int id);
}
