package com.sistemaventas.sistemaventas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private int idProducto;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "IdCategoria")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Categoria categoria;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Precio")
    private double precio;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Column(name = "Stock")
    private int stock;
}
