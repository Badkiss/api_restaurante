package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.ProductoEntityMapper;
import org.example.api_restaurante.Model.ProductoCompactoDTO;
import org.example.api_restaurante.Model.ProductoDTO;
import org.example.api_restaurante.Services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoServices productoServices;
    @Autowired
    private ProductoEntityMapper productoEntityMapper;
    @GetMapping("/all")
    public List<ProductoDTO> getAllProductos() {
        List<ProductoDTO> productoDTOS ;
        productoDTOS=productoServices.all();
        return productoDTOS;
    }
    @GetMapping("/id/{id}")
    public ProductoCompactoDTO findId(@PathVariable Long id){
        return productoServices.findId(id);
    }
    @GetMapping("/nombre/{nombre}")
    public ProductoCompactoDTO findId(@PathVariable String nombre){
        return productoServices.findNombre(nombre);
    }
    @PostMapping("/add")
    public String add(@RequestBody ProductoCompactoDTO productoCompacto){
       return productoServices.add(productoCompacto);
    }
    @PutMapping("/update")
    public String update(@RequestBody ProductoCompactoDTO productoCompacto){
        return productoServices.update(productoCompacto);
    }
    @DeleteMapping("/deleteId/{id}")
    public String deleteId(@PathVariable Long id){
        return productoServices.deleteById(id);
    }

    @DeleteMapping("deleteNombre/{nombre}")
    public String deleteNombre(@PathVariable String nombre){
        nombre=java.net.URLDecoder.decode(nombre, StandardCharsets.UTF_8);
        return productoServices.deleteByNombre(nombre);
    }

}
