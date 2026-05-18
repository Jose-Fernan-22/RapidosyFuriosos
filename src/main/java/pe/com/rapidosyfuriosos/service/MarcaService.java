package pe.com.rapidosyfuriosos.service;

import java.util.List;
import pe.com.rapidosyfuriosos.entity.MarcaEntity;

public interface MarcaService {
    List<MarcaEntity> findAll();
    List<MarcaEntity> findAllCustom();
    MarcaEntity findById(Long id);
    MarcaEntity add(MarcaEntity obj);
    MarcaEntity update(MarcaEntity obj, Long id);
    MarcaEntity delete(Long id);
    MarcaEntity enable(Long id);
}