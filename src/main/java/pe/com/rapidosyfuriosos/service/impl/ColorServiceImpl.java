package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.ColorEntity;
import pe.com.rapidosyfuriosos.repository.ColorRepository;
import pe.com.rapidosyfuriosos.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository repositorio;

    @Override
    public List<ColorEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ColorEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public ColorEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public ColorEntity add(ColorEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public ColorEntity update(ColorEntity obj, Long id) {
        ColorEntity objcol = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objcol);
        return repositorio.save(objcol);
    }

    @Override
    public ColorEntity delete(Long id) {
        ColorEntity objcol = repositorio.findById(id).get();
        objcol.setEstado(false);
        return repositorio.save(objcol);
    }

    @Override
    public ColorEntity enable(Long id) {
        ColorEntity objcol = repositorio.findById(id).get();
        objcol.setEstado(true);
        return repositorio.save(objcol);
    }
}