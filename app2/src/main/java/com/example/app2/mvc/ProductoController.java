package com.example.app2.mvc;

import com.example.app2.mvc.Producto;
import com.example.app2.mvc.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // GET /api/productos -> Consultar todos los productos
    @GetMapping
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // GET /api/productos/{id} -> Consultar producto por ID
    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable Long id) {
        return productoRepository.findById(id);
    }

    // POST, PUT, DELETE se implementarían aquí siguiendo el mismo patrón...
}
