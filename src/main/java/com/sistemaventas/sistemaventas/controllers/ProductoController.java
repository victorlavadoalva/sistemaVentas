package com.sistemaventas.sistemaventas.controllers;

import com.sistemaventas.sistemaventas.entity.Categoria;
import com.sistemaventas.sistemaventas.entity.Producto;
import com.sistemaventas.sistemaventas.repository.ProductoRepository;
import com.sistemaventas.sistemaventas.service.CategoriaService;
import com.sistemaventas.sistemaventas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //create new producto
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto){

        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
        /*Optional<Categoria> categoriaOptional = categoriaService.findById(producto.getCategoria().getIdCategoria());
        if(!categoriaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        producto.setCategoria(categoriaOptional.get());
        Producto productoGuardado = productoService.save(producto);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productoGuardado.getIdProducto()).toUri();

        return ResponseEntity.created(ubicacion).body(productoGuardado);*/
    //libro es producto
        //https://www.youtube.com/watch?v=mgXmTZZCsbI&list=LL&index=3&t=5148s&ab_channel=LaTecnolog%C3%ADaAvanza
    }














    //read a producto
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable int id){
        Optional<Producto> oProducto = productoService.findById(id);

        if(!oProducto.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oProducto);
    }

    //update a producto
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Producto productoDetails, @PathVariable(value = "id") int productoId){
        Optional<Producto> producto = productoService.findById(productoId);
        if(!producto.isPresent()){
            return ResponseEntity.notFound().build();
        }
        producto.get().setNombre(productoDetails.getNombre());
        producto.get().setPrecio(productoDetails.getPrecio());
        producto.get().setStock(productoDetails.getStock());
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
    }

    //delete a producto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int productoId){

        if(!productoService.findById(productoId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        productoService.deleteById(productoId);
        return ResponseEntity.ok().build();
    }

    //read all users

    @GetMapping
    public List<Producto> readAll(){
        return StreamSupport
                .stream(productoService.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
