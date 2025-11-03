package org.example.api_restaurante.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaPrimaDTO {
    private String nombre;
    private CantidadMedida cantidadMedida;
    private float precioMedida;
    private float cantidad;
    private Long proveedor;
}
