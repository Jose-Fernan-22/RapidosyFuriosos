package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.SexoEntity;
import pe.com.rapidosyfuriosos.repository.SexoRepository;
import pe.com.rapidosyfuriosos.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {

    @Autowired
    private SexoRepository repositorio;

    @Override
    public List<SexoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<SexoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public SexoEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public SexoEntity add(SexoEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public SexoEntity update(SexoEntity obj, Long id) {
        SexoEntity objsex = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objsex);
        return repositorio.save(objsex);
    }

    @Override
    public SexoEntity delete(Long id) {
        SexoEntity objsex = repositorio.findById(id).get();
        objsex.setEstado(false);
        return repositorio.save(objsex);
    }

    @Override
    public SexoEntity enable(Long id) {
        SexoEntity objsex = repositorio.findById(id).get();
        objsex.setEstado(true);
        return repositorio.save(objsex);
    }
}