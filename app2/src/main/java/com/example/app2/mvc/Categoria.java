package com.example.app2.mvc;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación Uno a Muchos con Producto
    // mappedBy indica el campo en la clase Producto que es el dueño de la relación
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    // El fetch por defecto es LAZY, lo cual es buena práctica para relaciones OneToMany
    // Es mejor no devolver la lista de productos por defecto para no sobrecargar la respuesta.
    private List<Producto> productos;
}