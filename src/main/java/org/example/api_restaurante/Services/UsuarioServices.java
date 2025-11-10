package org.example.api_restaurante.Services;

import org.example.api_restaurante.Mapper.UsuarioEntityMapper;
import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Model.UsuarioModel;
import org.example.api_restaurante.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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
    public String add(UsuarioDTO usuarioDTO) {
        if(repoUsuario.findByEmail(usuarioDTO.getEmail()) != null) {
            return "Usuario ya registrado con el email ";
        }
        repoUsuario.save(usuarioEntityMapper.toModel(usuarioDTO));
        return "Usuario Registrado";
    }
    public String update(UsuarioDTO usuarioDTO) {

        if(!repoUsuario.existsByEmail(usuarioDTO.getEmail())) {
         return  "Usuario no encontrado";
        }
          UsuarioModel usuarioModel = repoUsuario.findByEmail(usuarioDTO.getEmail());
            usuarioModel.setApellidos(usuarioDTO.getApellidos());
            usuarioModel.setNombre(usuarioDTO.getNombre());
            usuarioModel.setPassword(usuarioDTO.getPassword());
            usuarioModel.setTelefono(usuarioDTO.getTelefono());
          repoUsuario.save(usuarioModel);
        return "Usuario actualizado";
    }
    public String deleteById(Long id) {
        if (!repoUsuario.existsById(id)) {
            return "Usuario no encontrado";
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
