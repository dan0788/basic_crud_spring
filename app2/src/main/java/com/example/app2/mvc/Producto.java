package com.example.app2.mvc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    // Relación Muchos a Uno con Categoría
    // NOTA: @JsonIgnoreProperties es crucial para evitar un bucle infinito
    // durante la serialización JSON (Producto -> Categoria -> Productos -> Categoria...)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id") // Nombre de la columna de la FK en la tabla PRODUCTO
    @JsonIgnoreProperties({"hibernateLazyInitializer", "productos"})
    private Categoria categoria;
}
