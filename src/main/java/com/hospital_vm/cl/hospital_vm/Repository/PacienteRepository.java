package com.hospital_vm.cl.hospital_vm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.hospital_vm.cl.hospital_vm.Model.Paciente;
import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente , Long>{

    // Econtrar pacientes por apellido
    List<Paciente> findByApellido(String apellido);

    // Econtrar pacientes por correo electronico
    Paciente findByCorreo(String correo);

    // encuentra paciente por normbre y apellido
    List<Paciente> findByNombreAndApellido(String nombre, String apellido);

   
}
