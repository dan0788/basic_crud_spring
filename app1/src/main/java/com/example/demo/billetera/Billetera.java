package com.example.demo.billetera;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //crear getters y setters
@AllArgsConstructor
@NoArgsConstructor
public class Billetera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID será autogenerado por la DB
    private Long id;

    // 3. Campos Mapeados a Columnas
    private String color;
    private String propietario;


    // (Opcional: @Column(name = "stock_disponible") si el nombre de la columna es diferente)
    //private int stock;


}
