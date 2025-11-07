package com.example.app2.mvc;

import com.example.app2.mvc.Categoria;
import com.example.app2.mvc.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // GET /api/categorias -> Consultar todas las categorías
    @GetMapping
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // GET /api/categorias/{id} -> Consultar categoría por ID
    @GetMapping("/{id}")
    public Optional<Categoria> findById(@PathVariable Long id) {
        return categoriaRepository.findById(id);
    }

}