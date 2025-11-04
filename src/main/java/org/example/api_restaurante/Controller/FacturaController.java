package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.FacturaEntityMapper;
import org.example.api_restaurante.Model.FacturaCompactaDTO;
import org.example.api_restaurante.Services.FacturaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaServices facturaServices;
    @Autowired
    private FacturaEntityMapper facturaEntityMapper;
    @PostMapping("/addFactura")
    public String addFactura(@RequestBody FacturaCompactaDTO facturaCompactaDTO) {
        facturaServices.addFactura(facturaCompactaDTO);
        return "";
    }
}
