package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.UsuarioEntityMapper;
import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Model.UsuarioModel;
import org.example.api_restaurante.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServices usuarioServices;
    private UsuarioEntityMapper usuarioEntityMapper;
    @GetMapping("/all")
    public List<UsuarioDTO> getAllUsuarios() {
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        usuarioDTOS=usuarioServices.getAllUsuarios().stream().map(usuarioEntityMapper::toDTO).collect(Collectors.toList());
        return usuarioDTOS;
    }
    @GetMapping("/{id}")
    public UsuarioDTO getUsuario(@PathVariable Long id) {
        return usuarioEntityMapper.toDTO(usuarioServices.obtenerId(id));
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioServices.addUser(usuarioDTO);
        return "usuario creado";
    }
    @PutMapping("/updateUser")
    public String update(@RequestBody UsuarioModel usuarioModel) {
        usuarioServices.updateUsuario(usuarioModel);
        return "usuario actualizado";
    }
    @DeleteMapping("/deleteUser/{id}")
    public String delete(@PathVariable Long id) {
        usuarioServices.deleteUsuario(id);
        return "usuario eliminado";
    }
}
