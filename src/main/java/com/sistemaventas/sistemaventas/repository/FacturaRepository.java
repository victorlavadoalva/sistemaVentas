package com.sistemaventas.sistemaventas.repository;

import com.sistemaventas.sistemaventas.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer> {
}
