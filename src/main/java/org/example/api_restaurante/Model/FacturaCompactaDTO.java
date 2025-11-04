package org.example.api_restaurante.Model;

import lombok.Data;


import java.util.List;

@Data
public class FacturaCompactaDTO {
    private FacturaDTO facturaDTO;
    private List<LineaFacturaDTO> lineaFacturaDTOS;

}
