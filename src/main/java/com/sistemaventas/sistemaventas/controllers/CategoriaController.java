package com.sistemaventas.sistemaventas.controllers;

import com.sistemaventas.sistemaventas.entity.Categoria;
import com.sistemaventas.sistemaventas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    //create new Categoria
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    //read a categoria
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable int id){
        Optional<Categoria> oCategoria = categoriaService.findById(id);

        if(!oCategoria.isPresent()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(oCategoria);
    }

    //update a categoria
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Categoria categoriaDetails, @PathVariable(value = "id") int categoriaId){
        Optional<Categoria> categoria = categoriaService.findById(categoriaId);

        if(!categoria.isPresent()){
            return ResponseEntity.notFound().build();
        }
        categoria.get().setDescripcion(categoriaDetails.getDescripcion());
        categoria.get().setNombre(categoriaDetails.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int categoriaId)
    {
        if(!categoriaService.findById(categoriaId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        categoriaService.deleteById(categoriaId);
        return ResponseEntity.ok().build();
    }

    //read all categories
    @GetMapping
    public List<Categoria> readAll(){
        List<Categoria> categorias = StreamSupport
                .stream(categoriaService.findAll().spliterator(),false)
                .collect(Collectors.toList());
                return categorias;
    }
}
