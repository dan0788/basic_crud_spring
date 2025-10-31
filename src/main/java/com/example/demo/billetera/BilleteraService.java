package com.example.demo.billetera;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
//@RequiredArgsConstructor
public class BilleteraService {
    //Inyección de dependencias hacia el repositorio
    @Autowired
    private BilleteraRepository billeteraRepository;

    //consultar registros
    public List<Billetera> findAll(){
        return billeteraRepository.findAll();
    }

    //consultar id
    public Optional<Billetera> findById(Long id){
        return billeteraRepository.findById(id);
    }

    //guardar registro
    public Billetera save(Billetera entidad){
        return billeteraRepository.save(entidad);
    }

    //actualizar un registro(put y patch)
    public Billetera update(@PathVariable Long id, @RequestBody Billetera entidad) {
        entidad.setId(id);
        return billeteraRepository.save(entidad);
    }
    //borrar un registro
    public void deleteById(@PathVariable Long id) {
        billeteraRepository.deleteById(id);
    }
}
