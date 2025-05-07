package com.mvr.poliza.mappers;

import org.springframework.stereotype.Component;

import com.mvr.poliza.dtos.PolizaDto;
import com.mvr.poliza.entitys.InventarioEntity;
import com.mvr.poliza.entitys.PolizaEntity;

@Component
public class PolizaMapper {

    public PolizaDto toDtos(PolizaEntity polizaEntity) {
        InventarioEntity inventarioEntity = polizaEntity.getSku();
        InventarioEntity invent = new InventarioEntity(
            inventarioEntity.getSku(),
            inventarioEntity.getNombre()
        );
        return new PolizaDto(
            polizaEntity.getIdPoliza(),
            polizaEntity.getIdEmpleado(),
            invent,
            polizaEntity.getCantidad(),
            polizaEntity.getFecha()
        );
    }
}
