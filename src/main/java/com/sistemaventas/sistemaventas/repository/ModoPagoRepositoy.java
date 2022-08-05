package com.sistemaventas.sistemaventas.repository;

import com.sistemaventas.sistemaventas.entity.ModoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoPagoRepositoy extends JpaRepository<ModoPago,Integer> {
}
