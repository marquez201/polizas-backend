package com.mvr.poliza.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvr.poliza.dtos.PolizaDto;
import com.mvr.poliza.dtos.response.ApiResponse;
import com.mvr.poliza.dtos.response.Meta;
import com.mvr.poliza.entitys.EmpleadoEntity;
import com.mvr.poliza.entitys.InventarioEntity;
import com.mvr.poliza.entitys.PolizaEntity;
import com.mvr.poliza.exeptions.NegativeCantidadException;
import com.mvr.poliza.exeptions.ResourceNotFoundException;
import com.mvr.poliza.mappers.PolizaMapper;
import com.mvr.poliza.repositorys.PolizaRepository;
import com.mvr.poliza.services.PolizasService;
import com.mvr.poliza.utils.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PolizasServicesImpl implements PolizasService {

    final PolizaMapper polizaMapper;

    final PolizaRepository polizasRepository;

    final InventarioServiceImpl inventarioService;

    final EmpleadoServiceImpl empleadoService;

    UUID id = UUID.randomUUID();
    Meta meta = new Meta(id.toString(), ResponseMessage.MESSAGE_OK.getMsgInformativo());
    

    @Override
    public ApiResponse<String> deletePoliza(Integer idPoliza) {
        Optional<PolizaEntity> poliza = polizasRepository.findById(idPoliza);
        if (poliza.isPresent()) {
            var polizaEntity = poliza.get();
            var invent = inventarioService.getInventario(polizaEntity.getSku().getSku());
            int recuperarInvent = recuperarInventario(invent.getCantidad(), polizaEntity.getCantidad());
            inventarioService.saveNewCantidadInventario(invent.getSku(), recuperarInvent);

            polizasRepository.delete(polizaEntity);
            
            return new ApiResponse<String>(ResponseMessage.ELIMINAR_POLIZA.getMsgInformativo(), meta);
        } else {
            throw new ResourceNotFoundException(ResponseMessage.ELIMINAR_FALLO.getMsgInformativo());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse<List<PolizaDto>> getAllPolizas() {
        var polizas = convertToPolizasDtos(polizasRepository.findAll());
        return new ApiResponse<List<PolizaDto>>(polizas, meta);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiResponse<PolizaDto> getIdPoliza(Integer idPoliza) {
        Optional<PolizaEntity> poliza = polizasRepository.findById(idPoliza);
        if (poliza.isPresent()) {
            return new ApiResponse<PolizaDto>(polizaMapper.toDtos(poliza.get()), meta);
        } else {
            throw new ResourceNotFoundException(ResponseMessage.CONSULTA_FALLO.getMsgInformativo());
        }
    }

    @Override
    public PolizaEntity newPolizaSave(EmpleadoEntity empleadoEntity, InventarioEntity inventarioEntity,
            int cantidadPoliza, Date fecha) {
                PolizaEntity poliza = new PolizaEntity();
                poliza.setIdEmpleado(empleadoEntity);
                poliza.setSku(inventarioEntity);
                poliza.setCantidad(cantidadPoliza);
                poliza.setFecha(fecha);
        
                return polizasRepository.save(poliza);
    }

    @Override
    public ApiResponse<PolizaDto> savePoliza(PolizaDto polizaDto) {
        var empleado = empleadoService.getEmpleado(polizaDto.getIdEmpleadoDto().getIdEmpleado());
        var invent = inventarioService.getInventario(polizaDto.getSkuDto().getSku());
        int nuevaCantidad = calcularInventario(invent.getCantidad(), polizaDto.getCantidad());
        inventarioService.saveNewCantidadInventario(invent.getSku(), nuevaCantidad);
        var poliza = this.newPolizaSave(empleado, invent, polizaDto.getCantidad(), polizaDto.getFecha());

        return new ApiResponse<>(polizaMapper.toDtos(poliza), meta);
    }

    @Override
    public ApiResponse<String> updatePoliza(Integer idPoliza, int newCantidad) {
        var updateCantidad = 0;
        var inventNuevo = 0;
        var poliza = polizasRepository.findById(idPoliza).orElseThrow();
        var invent = inventarioService.getInventario(poliza.getSku().getSku());
        if (newCantidad > poliza.getCantidad()) {
            updateCantidad = newCantidad - poliza.getCantidad();
            inventNuevo = this.calcularInventario(invent.getCantidad(), updateCantidad);
        } else {
            updateCantidad = poliza.getCantidad() - newCantidad;
            inventNuevo = this.recuperarInventario(invent.getCantidad(), updateCantidad);
        }
        inventarioService.saveNewCantidadInventario(invent.getSku(), inventNuevo);
        poliza.setCantidad(newCantidad);
        polizasRepository.save(poliza);
        return new ApiResponse<String>(ResponseMessage.ACTUALIZAR_POLIZA.getMsgInformativo(), meta);
    }

    @Override
    public int calcularInventario(int cantidadInventario, int cantidadPoliza) {
        if (cantidadPoliza > cantidadInventario) {
            throw new NegativeCantidadException();
        } else {
            return cantidadInventario - cantidadPoliza;
        }
    }

    @Override
    public int recuperarInventario(int cantidadInventario, int cantidadPoliza) {
        return cantidadInventario + cantidadPoliza;
    }

    private List<PolizaDto> convertToPolizasDtos(List<PolizaEntity> listPolizaEntities) {
        return listPolizaEntities.stream().map(polizaMapper::toDtos).toList();
    }
    
}