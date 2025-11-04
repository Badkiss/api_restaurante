package org.example.api_restaurante.Services;

import org.example.api_restaurante.Mapper.ProductoEntityMapper;
import org.example.api_restaurante.Model.ProductoDTO;
import org.example.api_restaurante.Repository.RepositoryProducto;
import org.example.api_restaurante.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServices {
    @Autowired
    private RepositoryProducto repoProducto;
    @Autowired
    private ProductoEntityMapper productoEntityMapper;
    public void add(ProductoDTO productoDTO) {
        repoProducto.save(productoEntityMapper.toModel(productoDTO));
    }
}
