package com.mvr.poliza.services.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mvr.poliza.dtos.PolizaDto;
import com.mvr.poliza.dtos.response.ApiResponse;
import com.mvr.poliza.dtos.response.Meta;
import com.mvr.poliza.entitys.EmpleadoEnity;
import com.mvr.poliza.entitys.InventarioEntity;
import com.mvr.poliza.entitys.PolizaEntity;
import com.mvr.poliza.mappers.PolizaMapper;
import com.mvr.poliza.repositorys.PolizaRepository;
import com.mvr.poliza.services.PolizasService;
import com.mvr.poliza.utils.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PolizasServicesImpl implements PolizasService {

    final PolizaMapper polizaMapper;

    final PolizaRepository polizaRepository;

    final InventarioServiceImpl inventarioService;

    final EmpleadoServiceImpl empleadoService;

    UUID id = UUID.randomUUID();
    Meta meta = new Meta(id.toString(), ResponseMessage.MESSAGE_OK.getMsgInformativo());
    @Override
    public int calcularInventario(int cantidadInventario, int cantidadPoliza) {
        
        return 0;
    }

    @Override
    public String deletePoliza(Integer idPoliza) {
        
        return null;
    }

    @Override
    public ApiResponse<List<PolizaDto>> getAllPolizas() {
        
        return null;
    }

    @Override
    public ApiResponse<PolizaDto> getIdPoliza(Integer idPoliza) {
        
        return null;
    }

    @Override
    public PolizaEntity newPolizaSave(EmpleadoEnity empleadoEntity, InventarioEntity inventarioEntity,
            int cantidadPoliza, Date fecha) {
        
        return null;
    }

    @Override
    public int recuperarInventario(int cantidadInventario, int cantidadPoliza) {
        
        return 0;
    }

    @Override
    public ApiResponse<PolizaDto> savePoliza(PolizaDto polizaDto) {
        
        return null;
    }
    
    @Override
    public String updatePoliza(Integer idPoliza, int newCantidad) {
        
        return null;
    }
    
}
