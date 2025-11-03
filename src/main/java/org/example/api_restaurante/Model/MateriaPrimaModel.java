package org.example.api_restaurante.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "materia_prima")
public class MateriaPrimaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    private String nombre;
    private CantidadMedida cantidadMedida;
    private float precioMedida;
    private float cantidad;
    private Long proveedor;
}
