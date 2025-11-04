package org.example.api_restaurante.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaFacturaDTO {
    private Long producto;
    private int cantidad;
    private float precioTotal;
}
