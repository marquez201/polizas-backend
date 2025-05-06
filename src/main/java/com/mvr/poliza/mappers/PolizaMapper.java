package com.mvr.poliza.mappers;

import org.springframework.stereotype.Component;

import com.mvr.poliza.dtos.PolizaDto;
import com.mvr.poliza.entitys.PolizaEntity;

@Component
public class PolizaMapper {

    public PolizaDto toDtos(PolizaEntity polizaEntity) {
        return new PolizaDto(
            polizaEntity.getIdPoliza(),
            polizaEntity.getIdEmpleado(),
            polizaEntity.getSku(),
            polizaEntity.getCantidad(),
            polizaEntity.getFecha()
        );
    }
}
