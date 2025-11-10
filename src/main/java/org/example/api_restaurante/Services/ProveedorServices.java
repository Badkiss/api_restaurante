package org.example.api_restaurante.Services;


import org.example.api_restaurante.Mapper.ProveedorEntityMapper;
import org.example.api_restaurante.Model.ProveedorDTO;
import org.example.api_restaurante.Model.ProveedorModel;
import org.example.api_restaurante.Repository.RepositoryProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProveedorServices {
    @Autowired
    private RepositoryProveedor repoProveedor;
    @Autowired
    private ProveedorEntityMapper proveedorEntityMapper;

    public List<ProveedorDTO> all() {
        List<ProveedorDTO> proveedores=repoProveedor.findAll().stream().map(proveedorEntityMapper::toDTO).collect(Collectors.toList());
        return proveedores;
    }
    public ProveedorDTO findId(Long id) {
        return proveedorEntityMapper.toDTO(repoProveedor.findById(id).get());
    }
    public ProveedorDTO findEmail(String email) {
        return proveedorEntityMapper.toDTO(repoProveedor.findByEmail(email));
    }
    public String add(ProveedorDTO proveedorDTO) {
        ProveedorModel proveedorModel = proveedorEntityMapper.toModel(proveedorDTO);
        repoProveedor.save(proveedorModel);
        return "Proveedor agregado";
    }
    public String update(ProveedorDTO proveedorDTO) {
        if (!repoProveedor.existsByEmail(proveedorDTO.getEmail())) {
            return "proveedor no encontrado";
        }
        ProveedorModel proveedorModel = repoProveedor.findByEmail(proveedorDTO.getEmail());
        proveedorModel.setNombre(proveedorDTO.getNombre());
        proveedorModel.setTelefono(proveedorDTO.getTelefono());
        proveedorModel.setDireccion(proveedorDTO.getDireccion());
        repoProveedor.save(proveedorModel);
        return "Proveedor actualizado";
    }
    public String delete(Long id) {
        if (repoProveedor.existsById(id)) {
            repoProveedor.deleteById(id);
            return "Proveedor eliminado";
        }
        return "Proveedor no encontrado";
    }
}
