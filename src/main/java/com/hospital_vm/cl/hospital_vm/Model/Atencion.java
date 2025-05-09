package com.hospital_vm.cl.hospital_vm.Model;
import java.util.Date; 
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fecha;

   @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
     private Paciente paciente;
    

}
