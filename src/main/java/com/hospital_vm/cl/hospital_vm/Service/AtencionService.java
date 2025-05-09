package com.hospital_vm.cl.hospital_vm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.Model.Atencion;
import com.hospital_vm.cl.hospital_vm.Repository.AtencionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AtencionService {
    
    @Autowired
    private AtencionRepository atencionRepository;

    public List<Atencion> listar() {
        return atencionRepository.findAll();
    }

    public Atencion buscarPorId(long id) {
        return atencionRepository.findById(id).get();
    }

    public Atencion guardar(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    public void eliminar(long id) {
        atencionRepository.deleteById(id);
    }
}
