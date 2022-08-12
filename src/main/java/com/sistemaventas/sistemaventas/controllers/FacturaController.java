package com.sistemaventas.sistemaventas.controllers;

import com.sistemaventas.sistemaventas.entity.Cliente;
import com.sistemaventas.sistemaventas.entity.Factura;
import com.sistemaventas.sistemaventas.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    //create new factura
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Factura factura){
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
    }

    //read a factura
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable int id){
        Optional<Factura> oFactura = facturaService.findById(id);

        if(!oFactura.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oFactura);
    }

    //update a factura
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Factura facturaDetails, @PathVariable(value = "id") int facturaId){
        Optional<Factura> factura = facturaService.findById(facturaId);

        if(!factura.isPresent()){
            return ResponseEntity.notFound().build();
        }
        //BeanUtils.copyProperties(categoriaDetails, categoria.get());
        factura.get().setFecha(facturaDetails.getFecha());

        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura.get()));



    }

    //detele a factura

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int facturaId)
    {
        if(!facturaService.findById(facturaId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        facturaService.deleteById(facturaId);

        return ResponseEntity.ok().build();

    }

    //read all users
    @GetMapping
    public List<Factura> readAll(){

        return StreamSupport
                .stream(facturaService.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

}
