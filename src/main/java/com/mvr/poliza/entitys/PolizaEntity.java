package com.mvr.poliza.entitys;

import java.io.Serializable;
import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
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
public class PolizaEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpoliza")
    Integer idPoliza;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    EmpleadoEntity idEmpleado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sku", referencedColumnName = "sku")
    InventarioEntity sku;

    @Column(name = "cantidad")
    @Nonnull
    int cantidad;

    @Column(name = "fecha")
    @Nonnull
    Date fecha;
}
