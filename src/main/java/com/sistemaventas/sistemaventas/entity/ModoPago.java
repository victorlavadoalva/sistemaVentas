package com.sistemaventas.sistemaventas.entity;

import javax.persistence.*;

@Entity
@Table(name = "modopago")
public class ModoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumPago")
    private int numPago;
    @Column(name="Nombres")
    private String nombres;
    @Column(name = "OtrosDetalles")
    private String otrosDetalles;

    public int getNumPago() {
        return numPago;
    }

    public void setNumPago(int numPago) {
        this.numPago = numPago;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getOtrosDetalles() {
        return otrosDetalles;
    }

    public void setOtrosDetalles(String otrosDetalles) {
        this.otrosDetalles = otrosDetalles;
    }
}
