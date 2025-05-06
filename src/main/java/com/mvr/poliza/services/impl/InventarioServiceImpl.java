package com.mvr.poliza.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvr.poliza.entitys.InventarioEntity;
import com.mvr.poliza.exeptions.ResourceNotFoundException;
import com.mvr.poliza.repositorys.InventarioRepository;
import com.mvr.poliza.services.InventarioService;
import com.mvr.poliza.utils.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioService {

    final InventarioRepository inventarioRepository;

    @Override
    public InventarioEntity getInventario(Integer idInventario) {
        Optional<InventarioEntity> inventario = inventarioRepository.findById(idInventario);
        if (inventario.isPresent()) {
            return inventario.get();
        } else {
            throw new ResourceNotFoundException(ResponseMessage.ARTICULO_NO_EXISTE.getMsgInformativo());
        }
    }

    @Override
    public void saveNewCantidadInventario(Integer sku, int cantidad) {
        InventarioEntity invent = this.getInventario(sku);
       invent.setCantidad(cantidad);
       inventarioRepository.save(invent);
    }
}
