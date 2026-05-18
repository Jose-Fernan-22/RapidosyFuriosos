package pe.com.rapidosyfuriosos.service;

import java.util.List;
import pe.com.rapidosyfuriosos.entity.VehiculoEntity;

public interface VehiculoService {
    List<VehiculoEntity> findAll();
    List<VehiculoEntity> findAllCustom();
    VehiculoEntity findById(Long id);
    VehiculoEntity add(VehiculoEntity obj);
    VehiculoEntity update(VehiculoEntity obj, Long id);
    VehiculoEntity delete(Long id);
    VehiculoEntity enable(Long id);
}