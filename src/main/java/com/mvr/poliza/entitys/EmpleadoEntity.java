package com.mvr.poliza.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "empleados")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity implements Serializable{

    @Id
    @Column(name = "idempleado")
    Integer idEmpleado;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "apellido")
    String apellido;

    @Column(name = "puesto")
    String puesto;

}
