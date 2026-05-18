package pe.com.rapidosyfuriosos.service;

import java.util.List;
import pe.com.rapidosyfuriosos.entity.SexoEntity;

public interface SexoService {
    List<SexoEntity> findAll();
    List<SexoEntity> findAllCustom();
    SexoEntity findById(Long id);
    SexoEntity add(SexoEntity obj);
    SexoEntity update(SexoEntity obj, Long id);
    SexoEntity delete(Long id);
    SexoEntity enable(Long id);
}