package org.example.api_restaurante.Services;

import lombok.Getter;
import org.example.api_restaurante.Model.FacturaDTO;
import org.example.api_restaurante.Model.FacturaModel;
import org.example.api_restaurante.Model.LineaFacturaDTO;
import org.example.api_restaurante.Model.LineaFacturaModel;
import org.example.api_restaurante.Repository.RepositoryFactura;
import org.example.api_restaurante.Repository.RepositoryLineaFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.api_restaurante.Conexion.MiConector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class FacturaServices {
    @Autowired
    private RepositoryFactura repoFactura;
    private RepositoryLineaFactura repoLineaFactura;

    public void addFactura(FacturaModel facturaModel, List<LineaFacturaDTO> listaLineaFacturaDTO)  {
       repoFactura.save(facturaModel);
       Long idF= 0L;
       MiConector miConector=new MiConector();
        Connection con = miConector.getConnection();
       try(PreparedStatement prs= con.prepareStatement("select max(id) from factura")){
            ResultSet rs=prs.executeQuery();
            while(rs.next()){
                idF=rs.getLong(1);
            }
            for (LineaFacturaDTO lineaFacturaDTO : listaLineaFacturaDTO) {
                LineaFacturaModel lineaFacturaModel = new LineaFacturaModel();
                lineaFacturaModel.setPrecioTotal(lineaFacturaDTO.getPrecioTotal());
                lineaFacturaModel.setProducto(lineaFacturaDTO.getProducto());
                lineaFacturaModel.setCantidad(lineaFacturaDTO.getCantidad());
                lineaFacturaModel.setFecha(lineaFacturaDTO.getFecha());
                lineaFacturaModel.setFactura(idF);
                repoLineaFactura.save(lineaFacturaModel);
            }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
}
