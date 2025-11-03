package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Model.UsuarioModel;
import org.example.api_restaurante.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/crear")
    public String crear(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioServices.crear(usuarioDTO);
        return "creado";
    }
}
