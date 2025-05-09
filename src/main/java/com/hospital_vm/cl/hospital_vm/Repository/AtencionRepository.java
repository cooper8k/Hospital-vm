package com.hospital_vm.cl.hospital_vm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_vm.cl.hospital_vm.Model.Atencion;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {
    // Econtrar atenciones por id de paciente
    List<Atencion> findByPacienteId(Long pacienteId);

}
