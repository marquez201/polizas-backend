package com.mvr.poliza.services;

import java.util.Date;
import java.util.List;

import com.mvr.poliza.dtos.PolizaDto;
import com.mvr.poliza.dtos.response.ApiResponse;
import com.mvr.poliza.entitys.EmpleadoEnity;
import com.mvr.poliza.entitys.InventarioEntity;
import com.mvr.poliza.entitys.PolizaEntity;

public interface PolizasService {
    public int calcularInventario(int cantidadInventario, int cantidadPoliza);
    public int recuperarInventario(int cantidadInventario, int cantidadPoliza);
    public ApiResponse<PolizaDto> savePoliza(PolizaDto polizaDto);
    public ApiResponse<PolizaDto> getIdPoliza(Integer idPoliza);
    public String deletePoliza(Integer idPoliza);
    public ApiResponse<List<PolizaDto>> getAllPolizas();
    public String updatePoliza(Integer idPoliza, int newCantidad);
    public PolizaEntity newPolizaSave(EmpleadoEnity empleadoEntity, InventarioEntity inventarioEntity, int cantidadPoliza, Date fecha);
}
