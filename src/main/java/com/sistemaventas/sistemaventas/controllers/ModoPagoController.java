package com.sistemaventas.sistemaventas.controllers;

import com.sistemaventas.sistemaventas.entity.Cliente;
import com.sistemaventas.sistemaventas.entity.ModoPago;
import com.sistemaventas.sistemaventas.service.ModoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/modoPagos")
public class ModoPagoController {

    @Autowired
    private ModoPagoService modoPagoService;

    //create new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModoPago modoPago){
        return ResponseEntity.status(HttpStatus.CREATED).body(modoPagoService.save(modoPago));
    }

    //read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable int id){
        Optional<ModoPago> oModoPago = modoPagoService.findById(id);

        if (!oModoPago.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oModoPago);
    }

    //update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody ModoPago modoPagoDetails, @PathVariable(value = "id") int modoPagoId){
        Optional<ModoPago> modoPago = modoPagoService.findById(modoPagoId);

        if(!modoPago.isPresent()){
            return ResponseEntity.notFound().build();
        }
        modoPago.get().setNombres(modoPagoDetails.getNombres());
        modoPago.get().setOtrosDetalles(modoPagoDetails.getOtrosDetalles());

        return ResponseEntity.status(HttpStatus.CREATED).body(modoPagoService.save(modoPago.get()));


    }

    //delete an user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int modoPagoId){

        if (!modoPagoService.findById(modoPagoId).isPresent()) {

            return ResponseEntity.notFound().build();
        }
        modoPagoService.deleteById(modoPagoId);
        return ResponseEntity.ok().build();
    }

    //read all users
    @GetMapping
    public List<ModoPago> readAll(){
        List<ModoPago> modoPagos = StreamSupport
                .stream(modoPagoService.findAll().spliterator(),false)
                .collect(Collectors.toList());

        return modoPagos;
    }
}
