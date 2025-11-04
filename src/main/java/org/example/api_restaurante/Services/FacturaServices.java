package org.example.api_restaurante.Services;

import lombok.Getter;
import org.example.api_restaurante.Mapper.FacturaEntityMapper;
import org.example.api_restaurante.Mapper.LineaFacturaEntityMapper;
import org.example.api_restaurante.Model.*;
import org.example.api_restaurante.Repository.RepositoryFactura;
import org.example.api_restaurante.Repository.RepositoryLineaFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FacturaServices {
    @Autowired
    private RepositoryFactura repoFactura;
    @Autowired
    private RepositoryLineaFactura repoLineaFactura;
    @Autowired
    private FacturaEntityMapper facturaEntityMapper;
    @Autowired
    private LineaFacturaEntityMapper lineaFacturaEntityMapper;

   public void addFactura(FacturaCompactaDTO facturaCompacta)  {
       isValidFacturaCompacta(facturaCompacta);
       FacturaModel facturaModel= repoFactura.save(facturaEntityMapper.toModel(facturaCompacta.getFacturaDTO()));
       List<LineaFacturaModel> lineasFactura=new ArrayList<>();

        for (LineaFacturaDTO lineaFacturaDTO : facturaCompacta.getLineaFacturaDTOS()) {
            LineaFacturaModel lineaFacturaModel= lineaFacturaEntityMapper.toModel(lineaFacturaDTO);
            lineaFacturaModel.setFactura(facturaModel);
            lineasFactura.add(lineaFacturaModel);
        }
        facturaModel.setLineasFactura(lineasFactura);
        repoFactura.save(facturaModel);


    }

    private void isValidFacturaCompacta(FacturaCompactaDTO facturaCompacta) {
       if(facturaCompacta.getFacturaDTO() == null){
           throw new RuntimeException("Factura no puede ser nula");
       }
       if(facturaCompacta.getFacturaDTO().getId() != null){
           throw new RuntimeException("Factura no puede tener id");
       }
       if (!sumaTotal(facturaCompacta)){
           throw new RuntimeException("Factura no cuadra total");
       }
    }

    private boolean sumaTotal(FacturaCompactaDTO facturaCompacta) {
       float total=0;
       for (LineaFacturaDTO lineaFacturaDTO : facturaCompacta.getLineaFacturaDTOS()) {
           total+=lineaFacturaDTO.getPrecioTotal();
       }
       return total==facturaCompacta.getFacturaDTO().getTotal();
    }
}
