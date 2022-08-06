package com.sistemaventas.sistemaventas.repository;

import com.sistemaventas.sistemaventas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
