package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.MesaEntityMapper;
import org.example.api_restaurante.Model.MesaDTO;
import org.example.api_restaurante.Model.MesaModel;
import org.example.api_restaurante.Services.MesaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {
    @Autowired
    private MesaServices mesaServices;
    @Autowired
    private MesaEntityMapper mesaEntityMapper;

    @GetMapping("/all")
    public List<MesaModel> getAllMesa() {
       return mesaServices.allMesa();
    }
    @GetMapping("/{id}")
    public MesaModel getMesa(@PathVariable Long id) {
        return mesaServices.mesaById(id);
    }
    @PostMapping("/add")
    public void addMesa(@RequestBody MesaDTO mesaDTO) {
        mesaServices.addMesa(mesaDTO);
    }
    @PutMapping("/update")
    public void updateMesa(@RequestBody MesaDTO mesaDTO) {
        mesaServices.updateMesa(mesaEntityMapper.toModel(mesaDTO));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMesa(@PathVariable Long id) {
        mesaServices.deleteMesa(id);
    }
}
