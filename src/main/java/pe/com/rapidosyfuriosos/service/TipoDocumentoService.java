package pe.com.rapidosyfuriosos.service;

import java.util.List;
import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;

public interface TipoDocumentoService {
    List<TipoDocumentoEntity> findAll();
    List<TipoDocumentoEntity> findAllCustom();
    TipoDocumentoEntity findById(Long id);
    TipoDocumentoEntity add(TipoDocumentoEntity obj);
    TipoDocumentoEntity update(TipoDocumentoEntity obj, Long id);
    TipoDocumentoEntity delete(Long id);
    TipoDocumentoEntity enable(Long id);
}