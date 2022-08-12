package com.sistemaventas.sistemaventas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private int idProducto;
    @ManyToOne(optional = false)
    @JoinColumn(name = "IdCategoria")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Categoria categoria;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Precio")
    private double precio;
    @Column(name = "Stock")
    private int stock;
    public Producto() {}




}
