package com.mvr.poliza.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "inventarios")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioEntity implements Serializable{

    @Id
    @Column(name = "sku")
    Integer sku;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "cantidad")
    int cantidad;
}
