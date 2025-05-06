package com.mvr.poliza.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvr.poliza.entitys.EmpleadoEnity;
import com.mvr.poliza.exeptions.ResourceNotFoundException;
import com.mvr.poliza.repositorys.EmpleadoRepository;
import com.mvr.poliza.services.EmpleadoService;
import com.mvr.poliza.utils.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    final EmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public EmpleadoEnity getEmpleado(Integer idEmpleado) {
        var empleado = empleadoRepository.findById(idEmpleado);
        if (empleado.isPresent()) {
            return empleado.get();
        } else {
            throw new ResourceNotFoundException(ResponseMessage.EMPLEADO_NO_EXISTE.getMsgInformativo());
        }
    }

}
