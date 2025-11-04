package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.ProductoEntityMapper;
import org.example.api_restaurante.Model.ProductoDTO;
import org.example.api_restaurante.Services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoServices productoServices;

    @PostMapping("/add")
    public void add(@RequestBody ProductoDTO productoDTO){
        productoServices.add(productoDTO);
    }

}
