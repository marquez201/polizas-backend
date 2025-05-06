package com.mvr.poliza.services;

import com.mvr.poliza.entitys.InventarioEntity;

public interface InventarioService {
    public InventarioEntity getInventario(Integer idInventario);
    public void saveNewCantidadInventario(Integer sku, int cantidad);
}
