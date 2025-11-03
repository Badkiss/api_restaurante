package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.FacturaEntityMapper;
import org.example.api_restaurante.Model.FacturaDTO;
import org.example.api_restaurante.Model.LineaFacturaDTO;
import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Services.FacturaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaServices facturaServices;
    private FacturaEntityMapper facturaEntityMapper;
    @PostMapping("/addFactura")
    public String addFactura(@RequestBody FacturaDTO facturaDTO, @RequestBody List<LineaFacturaDTO> listaLineaFacturaDTO) {
        facturaServices.addFactura(facturaEntityMapper.toModel(facturaDTO),listaLineaFacturaDTO);
        return "";
    }
}
