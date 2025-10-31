package com.example.demo.billetera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dan")
public class BilleteraController {
    @Autowired
    private BilleteraService billeteraService;

    //consultar registros
    @GetMapping()
    public List<Billetera> findAll(){
        return billeteraService.findAll();
    }

    //consultar id
    @GetMapping("/{id}")
    public Optional<Billetera> findById(Long id){
        return billeteraService.findById(id);
    }

    @PostMapping()
    //guardar registro
    public Billetera save(@RequestBody Billetera entidad){
        return billeteraService.save(entidad);
    }

    //actualizar un registro(put y patch)
    @PutMapping("/{id}")
    public Billetera update(@PathVariable Long id, @RequestBody Billetera entidad) {
        entidad.setId(id);
        return billeteraService.save(entidad);
    }
    //borrar un registro
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        billeteraService.deleteById(id);
    }
}
