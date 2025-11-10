package org.example.api_restaurante.Services;

import org.example.api_restaurante.Mapper.ProductoEntityMapper;
import org.example.api_restaurante.Mapper.RecetaEntityMapper;
import org.example.api_restaurante.Model.*;
import org.example.api_restaurante.Repository.RepositoryProducto;
import org.example.api_restaurante.Repository.RepositoryReceta;
import org.example.api_restaurante.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductoServices {
    @Autowired
    private RepositoryProducto repoProducto;
    @Autowired
    private ProductoEntityMapper productoEntityMapper;
    @Autowired
    private RecetaEntityMapper recetaEntityMapper;
    @Autowired
    private RepositoryReceta repoReceta;
    public List<ProductoDTO> all() {
        return repoProducto.findAll().stream().map(productoEntityMapper::toDTO).collect(Collectors.toList());
    }
    public ProductoCompactoDTO findId(Long id) {
        ProductoCompactoDTO productoCompactoDTO = new ProductoCompactoDTO();
            if (!repoProducto.existsById(id)) {
                throw new RuntimeException("Producto no existe");
            }
            ProductoModel productoModel= repoProducto.findById(id).orElse(null);
            productoCompactoDTO.setProductoDTO(productoEntityMapper.toDTO(productoModel));
            List<RecetaDTO> recetas=buscarRecetas(productoModel);
             if(recetas == null){
             return productoCompactoDTO;
            }
            productoCompactoDTO.setRecetas(recetas);
             return productoCompactoDTO;

    }
    public ProductoCompactoDTO findNombre(String nombre) {
        ProductoCompactoDTO productoCompactoDTO = new ProductoCompactoDTO();
        if(!repoProducto.existsByNombre(nombre)) {
            throw new RuntimeException("Producto no existe");
        }
        ProductoModel productoModel= repoProducto.findByNombre(nombre);
        productoCompactoDTO.setProductoDTO(productoEntityMapper.toDTO(productoModel));
        List<RecetaDTO> recetas=buscarRecetas(productoModel);
        if(recetas == null){
            return productoCompactoDTO;
        }
        productoCompactoDTO.setRecetas(recetas);
        return productoCompactoDTO;

    }
    public String add(ProductoCompactoDTO productoCompacto) {
        if (repoProducto.existsByNombre(productoCompacto.getProductoDTO().getNombre())){
            return "Producto ya con el mismo nombre";
        }
        ProductoModel producto= repoProducto.save(productoEntityMapper.toModel(productoCompacto.getProductoDTO()));
        List<RecetaModel> recetas=new ArrayList<>();
        for (RecetaDTO recetaDTO : productoCompacto.getRecetas()) {
            RecetaModel recetaModel= recetaEntityMapper.toModel(recetaDTO);
            recetaModel.setProducto(producto);
            recetas.add(recetaModel);
        }
        producto.setRecetas(recetas);
        repoProducto.save(producto);
        return "Producto añadido";
    }
    public String update(ProductoCompactoDTO productoCompacto) {
        if (!repoProducto.existsByNombre(productoCompacto.getProductoDTO().getNombre())){
            return "Producto no encontrado";
        }
        ProductoModel productoModel= repoProducto.findByNombre(productoCompacto.getProductoDTO().getNombre());
        productoModel.setPrecio(productoCompacto.getProductoDTO().getPrecio());
        repoReceta.deleteByProducto_Id(productoModel.getId());
        List<RecetaModel> recetas= productoCompacto.getRecetas().stream().map(recetaDTO -> {
            RecetaModel recetaModel= recetaEntityMapper.toModel(recetaDTO);
            recetaModel.setProducto(productoModel);
            return recetaModel;
        }).collect(Collectors.toList());
        productoModel.setRecetas(recetas);
        repoProducto.save(productoModel);
        return "Producto actualizado";
    }
    public String deleteById(Long id) {
        if (!repoProducto.existsById(id)) {
            return "Producto no existe";
        } else if (!repoReceta.findByProducto_Id(id).isEmpty()) {
            List<RecetaModel> recetas=repoReceta.findByProducto_Id(id);
            repoReceta.deleteAll(recetas);
        }
        repoProducto.deleteById(id);
        return "Producto y recetas eliminado";
    }
    public String deleteByNombre(String nombre) {
        if (!repoProducto.existsByNombre(nombre)) {
            return "Producto no existe";
        }else if (!repoReceta.findByProducto_Nombre(nombre).isEmpty()) {
            List<RecetaModel> recetas=repoReceta.findByProducto_Nombre(nombre);
            repoReceta.deleteAll(recetas);
        }
        repoProducto.deleteByNombre(nombre);
        return "Producto y recetas eliminado";
    }


    private List<RecetaDTO> buscarRecetas(ProductoModel producto) {
        List<RecetaModel> recetas = repoReceta.findByProducto_Id(producto.getId());
        if (recetas.isEmpty()) {
            return null;
        }
        return recetas.stream().map(recetaEntityMapper::toDTO).collect(Collectors.toList());
    }
}


