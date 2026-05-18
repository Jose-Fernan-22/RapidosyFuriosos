package pe.com.rapidosyfuriosos.service;

import java.util.List;
import pe.com.rapidosyfuriosos.entity.ColorEntity;

public interface ColorService {
    List<ColorEntity> findAll();
    List<ColorEntity> findAllCustom();
    ColorEntity findById(Long id);
    ColorEntity add(ColorEntity obj);
    ColorEntity update(ColorEntity obj, Long id);
    ColorEntity delete(Long id);
    ColorEntity enable(Long id);
}