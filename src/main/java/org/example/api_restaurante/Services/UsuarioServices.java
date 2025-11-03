package org.example.api_restaurante.Services;

import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Model.UsuarioModel;
import org.example.api_restaurante.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
    @Autowired
    private RepositoryUsuario repoUsuario;

    public void crear(UsuarioDTO usuarioDTO) {

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNombre(usuarioDTO.getNombre());
        usuarioModel.setApellidos(usuarioDTO.getApellidos());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setTelefono(usuarioDTO.getTelefono());
        repoUsuario.save(usuarioModel);
    }
}
