package com.sistemaventas.sistemaventas.controllers;

import com.sistemaventas.sistemaventas.entity.Cliente;
import com.sistemaventas.sistemaventas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    //create new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    //read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable int id){
        Optional<Cliente> oCliente = clienteService.findById(id);

        if(!oCliente.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCliente);
    }

    //update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Cliente clienteDetails, @PathVariable(value = "id") int clienteId){
        Optional<Cliente> cliente = clienteService.findById(clienteId);

        if(!cliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        //BeanUtils.copyProperties(categoriaDetails, categoria.get());
        cliente.get().setNombre(clienteDetails.getNombre());
        cliente.get().setApellido(clienteDetails.getApellido());
        cliente.get().setTelefono(clienteDetails.getTelefono());
        cliente.get().setMesa(clienteDetails.getMesa());
        cliente.get().setEmail(clienteDetails.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));



    }

    //detele an user

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int clienteId)
    {
        if(!clienteService.findById(clienteId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteById(clienteId);

        return ResponseEntity.ok().build();

    }

    //read all users
    @GetMapping
    public List<Cliente> readAll(){
        List<Cliente> clientes= StreamSupport
                .stream(clienteService.findAll().spliterator(),false)
                .collect(Collectors.toList());

        return clientes;
    }

}
