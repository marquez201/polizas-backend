package com.mvr.poliza.dtos;

import java.io.Serializable;
import java.util.Date;

import com.mvr.poliza.entitys.EmpleadoEnity;
import com.mvr.poliza.entitys.InventarioEntity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolizaDto implements Serializable {

    Integer idPoliza;

    @Valid
    @NotBlank(message = "CAMPO REQUERIDO")
    EmpleadoEnity idEmpleadoDto;

    @Valid
    @NotBlank(message = "CAMPO REQUERIDO")
    InventarioEntity skuDto;

    int cantidad;
    
    @FutureOrPresent
    Date fecha;

}
