package com.sistemaventas.sistemaventas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@ConstructorBinding
@Entity
@Table(name= "factura")

public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFactura")
    private int idFactura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IdCliente")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NumPago")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ModoPago modoPago;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    public Factura(){}
}

