package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.MateriaPrimaEntityMapper;
import org.example.api_restaurante.Model.MateriaPrimaDTO;
import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.example.api_restaurante.Repository.RepositoryMateriaPrima;
import org.example.api_restaurante.Services.MateriaPrimaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/material")
public class MateriaPrimaController {
    @Autowired
    private MateriaPrimaServices materiaPrimaServices;
    @Autowired
    private MateriaPrimaEntityMapper materiaPrimaEntityMapper;

    @GetMapping("/all")
    public List<MateriaPrimaDTO> getAllMateriaPrima() {

        return materiaPrimaServices.getAll();
    }
    @GetMapping("/{id}")
    public MateriaPrimaDTO getMateriaPrimaId(@PathVariable Long id) {
        return materiaPrimaServices.getMateriaPrimaById(id);
    }
    @GetMapping("/{nombre}")
    public List<MateriaPrimaDTO> getMateriaPrimaName(@PathVariable String nombre ){
        return materiaPrimaServices.getMateriaPrimaByNombre(nombre);
    }
    @PostMapping("/add")
    public String addMateriaPrima(@RequestBody MateriaPrimaDTO materiaPrimaDTO) {
     return   materiaPrimaServices.add(materiaPrimaDTO);
    }
    @PutMapping("/update")
    public String updateMateriaPrima(@RequestBody MateriaPrimaDTO materiaPrimaDTO) {
     return   materiaPrimaServices.update(materiaPrimaDTO);
    }
   @DeleteMapping("/delete/{nombre}/{proveedor}")
    public String deleteMateriaPrima(@PathVariable String nombre,@PathVariable Long proveedor) {
       return   materiaPrimaServices.delete(nombre,proveedor);
   }
}
