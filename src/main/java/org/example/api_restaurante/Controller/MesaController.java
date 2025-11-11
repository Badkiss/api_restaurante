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
    public List<MesaDTO> getAllMesa() {
       return mesaServices.allMesa();
    }
    @GetMapping("/{id}")
    public MesaDTO getMesa(@PathVariable Long id) {
        return mesaServices.mesaById(id);
    }
    @PostMapping("/add")
    public String addMesa(@RequestBody MesaDTO mesaDTO) {
     return    mesaServices.addMesa(mesaDTO);
    }
    @PutMapping("/update")
    public String updateMesa(@RequestBody MesaDTO mesaDTO) {
      return   mesaServices.updateMesa(mesaDTO);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteMesa(@PathVariable Long id) {
      return   mesaServices.deleteMesa(id);
    }
}
