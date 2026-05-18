package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.MarcaEntity;
import pe.com.rapidosyfuriosos.repository.MarcaRepository;
import pe.com.rapidosyfuriosos.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository repositorio;

    @Override
    public List<MarcaEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<MarcaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public MarcaEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public MarcaEntity add(MarcaEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public MarcaEntity update(MarcaEntity obj, Long id) {
        MarcaEntity objmar = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objmar);
        return repositorio.save(objmar);
    }

    @Override
    public MarcaEntity delete(Long id) {
        MarcaEntity objmar = repositorio.findById(id).get();
        objmar.setEstado(false);
        return repositorio.save(objmar);
    }

    @Override
    public MarcaEntity enable(Long id) {
        MarcaEntity objmar = repositorio.findById(id).get();
        objmar.setEstado(true);
        return repositorio.save(objmar);
    }
}