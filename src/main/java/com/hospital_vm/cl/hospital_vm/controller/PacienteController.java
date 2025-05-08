package com.hospital_vm.cl.hospital_vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.Model.Paciente;
import com.hospital_vm.cl.hospital_vm.Service.PacienteService;

@RestController
@RequestMapping("api/v1/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listar() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {

            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(pacientes); 
    }

    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        Paciente productonuevo = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(productonuevo);
    }

    @GetMapping("{id}/buscar")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) {
        try {
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }

       
    } 

    @PutMapping("{id}/actualizar")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id,@RequestBody Paciente paciente) {
        try {
            Paciente pac = pacienteService.findById(id);
            pac.setId(id);
            pac.setNombre(paciente.getNombre());
            pac.setApellido(paciente.getApellido());
            pac.setRut(paciente.getRut());
            pac.setFechaNacimiento(paciente.getFechaNacimiento());
            pac.setCorreo(paciente.getCorreo());

            pacienteService.save(pac);
            return ResponseEntity.ok(pac);

        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 
        }
    }


    @DeleteMapping("{id}/eliminar")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build(); 
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); 

        }
    }
}