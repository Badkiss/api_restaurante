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
    @Autowired
    private UsuarioEntityMapper usuarioEntityMapper;
    @GetMapping("/all")
    public List<UsuarioDTO> getAllUsuarios() {
        List<UsuarioDTO> usuarioDTOS ;
        usuarioDTOS=usuarioServices.all();
        return usuarioDTOS;
    }
    @GetMapping("/id/{id}")
    public UsuarioDTO findId(@PathVariable Long id){
        return usuarioEntityMapper.toDTO(usuarioServices.findId(id));
    }
    @GetMapping("/email/{email}")
    public UsuarioDTO findEmail(@PathVariable String email){
        return usuarioEntityMapper.toDTO(usuarioServices.findEmail(email));
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioServices.add(usuarioDTO);
        return "usuario creado";
    }
    @PutMapping("/update")
    public String update(@RequestBody UsuarioDTO usuarioDTO) {
       return usuarioServices.update(usuarioDTO);
    }
    @DeleteMapping("/deleteId/{id}")
    public String deleteId(@PathVariable Long id) {
        return usuarioServices.deleteById(id);
    }
    @DeleteMapping("/delete/{email}")
    public String deleteEmail(@PathVariable String email) {
      return   usuarioServices.deleteByEmail(email);
    }
}
