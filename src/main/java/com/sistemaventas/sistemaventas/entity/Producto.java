package com.sistemaventas.sistemaventas.entity;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private int idProducto;
    @Column(name = "IdCategoria")
    private int idCategoria;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Precio")
    private double precio;
    @Column(name = "Stock")
    private int stock;
}
