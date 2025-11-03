package org.example.api_restaurante.Services;

import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Model.UsuarioModel;
import org.example.api_restaurante.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServices {
    @Autowired
    private RepositoryUsuario repoUsuario;

    public void addUser(UsuarioDTO usuarioDTO) {

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNombre(usuarioDTO.getNombre());
        usuarioModel.setApellidos(usuarioDTO.getApellidos());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setTelefono(usuarioDTO.getTelefono());
        repoUsuario.save(usuarioModel);
    }
    public List<UsuarioModel> getAllUsuarios() {
        List<UsuarioModel> usuarioDTOS = new ArrayList<>();
        usuarioDTOS=repoUsuario.findAll();
        return usuarioDTOS;
    }
    public UsuarioModel obtenerId(Long id) {
       return repoUsuario.findById(id).get();
    }
    public UsuarioModel updateUsuario(UsuarioModel usuarioModel) {
         return repoUsuario.save(usuarioModel);
    }
    public void deleteUsuario(Long id) {
        if (!repoUsuario.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        repoUsuario.deleteById(id);

    }
}
