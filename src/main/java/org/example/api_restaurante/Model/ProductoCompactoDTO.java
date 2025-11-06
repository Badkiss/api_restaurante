package org.example.api_restaurante.Model;

import lombok.Data;

import java.util.List;

@Data
public class ProductoCompactoDTO {
   private ProductoDTO productoDTO;
   private List<RecetaDTO> recetas;
}
