package org.example.api_restaurante.Services;

import org.example.api_restaurante.Mapper.UsuarioEntityMapper;
import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Model.UsuarioModel;
import org.example.api_restaurante.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServices {
    @Autowired
    private RepositoryUsuario repoUsuario;
    @Autowired
    private UsuarioEntityMapper usuarioEntityMapper;

    public List<UsuarioDTO> all() {
        List<UsuarioDTO> usuarios;
        usuarios=repoUsuario.findAll().stream().map(usuarioEntityMapper::toDTO).collect(Collectors.toList());
        return usuarios;
    }
    public UsuarioModel findId(Long id) {
       return repoUsuario.findById(id).get();
    }
    public UsuarioModel findEmail(String email) {
        return repoUsuario.findByEmail(email);
    }
    public void add(UsuarioDTO usuarioDTO) {

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNombre(usuarioDTO.getNombre());
        usuarioModel.setApellidos(usuarioDTO.getApellidos());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setTelefono(usuarioDTO.getTelefono());
        repoUsuario.save(usuarioModel);
    }
    public String update(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = usuarioEntityMapper.toModel(usuarioDTO);
        if(!repoUsuario.existsById(usuarioModel.getId())) {
            throw new RuntimeException("Usuario no encontrado");
        }
          repoUsuario.save(usuarioModel);
        return "Usuario actualizado";
    }
    public String deleteById(Long id) {
        if (!repoUsuario.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        repoUsuario.deleteById(id);
        return "Usuario eliminado";

    }
    public String deleteByEmail(String email) {
        if (!repoUsuario.existsByEmail(email)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        repoUsuario.deleteByEmail(email);
        return "Usuario eliminado";
    }
}
