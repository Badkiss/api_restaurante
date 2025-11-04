package org.example.api_restaurante.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    private Long id;
    private float total;
    private Long idMesa;
    private Long usuario;

}
