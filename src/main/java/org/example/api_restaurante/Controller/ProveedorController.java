package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.ProveedorEntityMapper;
import org.example.api_restaurante.Model.ProveedorDTO;
import org.example.api_restaurante.Services.ProveedorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorServices proveedorServices;
    @Autowired
    private ProveedorEntityMapper proveedorEntityMapper;

    @GetMapping("/all")
    public List<ProveedorDTO> all(){
        List<ProveedorDTO> proveedores;
        return proveedores=proveedorServices.all();
    }
    @GetMapping("/id/{id}")
    public ProveedorDTO findId(@PathVariable Long id){
        return proveedorServices.findId(id);
    }
    @GetMapping("/email/{email}")
    public ProveedorDTO findEmail(@PathVariable String email){
        return proveedorServices.findEmail(email);
    }
    @PostMapping("/add")
    public String add(@RequestBody ProveedorDTO proveedorDTO){
        return proveedorServices.add(proveedorDTO);
    }
    @PutMapping("/update")
    public String update(@RequestBody ProveedorDTO proveedorDTO){
        return proveedorServices.update(proveedorDTO);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody Long id){
        return proveedorServices.delete(id);
    }
}
