package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.VehiculoEntity;
import pe.com.rapidosyfuriosos.repository.VehiculoRepository;
import pe.com.rapidosyfuriosos.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository repositorio;

    @Override
    public List<VehiculoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<VehiculoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public VehiculoEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public VehiculoEntity add(VehiculoEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public VehiculoEntity update(VehiculoEntity obj, Long id) {
        VehiculoEntity objveh = repositorio.findById(id).get();
        // Ignoramos copiar el "codigo" para no sobrescribir el ID original accidentalmente
        BeanUtils.copyProperties(obj, objveh, "codigo");
        return repositorio.save(objveh);
    }

    @Override
    public VehiculoEntity delete(Long id) {
        VehiculoEntity objveh = repositorio.findById(id).get();
        objveh.setEstado(false);
        return repositorio.save(objveh);
    }

    @Override
    public VehiculoEntity enable(Long id) {
        VehiculoEntity objveh = repositorio.findById(id).get();
        objveh.setEstado(true);
        return repositorio.save(objveh);
    }
}