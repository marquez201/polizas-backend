package com.mvr.poliza.dtos;

import java.io.Serializable;
import java.util.Date;

import com.mvr.poliza.entitys.EmpleadoEntity;
import com.mvr.poliza.entitys.InventarioEntity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolizaDto implements Serializable {

    Integer idPoliza;

    @Valid
    @NotNull(message = "CAMPO REQUERIDO")
    EmpleadoEntity idEmpleadoDto;

    @Valid
    @NotNull(message = "CAMPO REQUERIDO")
    InventarioEntity skuDto;

    int cantidad;
    
    @FutureOrPresent
    Date fecha;

}
