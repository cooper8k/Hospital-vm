package com.hospital_vm.cl.hospital_vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.Model.Atencion;
import com.hospital_vm.cl.hospital_vm.Service.AtencionService;

@RestController
@RequestMapping("api/v1/atencion")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Atencion>> listar() {
        List<Atencion> atenciones = atencionService.listar();
        if (atenciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion) {
        Atencion atencionNuevo = atencionService.guardar(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(atencionNuevo);
    }

    @GetMapping("{id}/buscar")
    public ResponseEntity<Atencion> buscar(@PathVariable Integer id) {
        try {
            Atencion atencion = atencionService.buscarPorId(id);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("{id}/eliminar")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            atencionService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
