package com.mvr.poliza.entitys;

import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "polizas")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolizaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpoliza")
    Integer idPoliza;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    EmpleadoEnity idEmpleado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sku", referencedColumnName = "sku")
    InventarioEntity sku;

    @Column(name = "cantidad")
    int cantidad;

    @Column(name = "fecha")
    @NonNull
    Date fecha;
}
