package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.ClienteEntity;
import pe.com.rapidosyfuriosos.repository.ClienteRepository;
import pe.com.rapidosyfuriosos.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<ClienteEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ClienteEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public ClienteEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public ClienteEntity add(ClienteEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public ClienteEntity update(ClienteEntity obj, Long id) {
        ClienteEntity objcli = repositorio.findById(id).get();
        // BeanUtils copia los datos del nuevo objeto al existente
        BeanUtils.copyProperties(obj, objcli, "codigo"); // Ignoramos el código por seguridad
        return repositorio.save(objcli);
    }

    @Override
    public ClienteEntity delete(Long id) {
        ClienteEntity objcli = repositorio.findById(id).get();
        objcli.setEstado(false);
        return repositorio.save(objcli);
    }

    @Override
    public ClienteEntity enable(Long id) {
        ClienteEntity objcli = repositorio.findById(id).get();
        objcli.setEstado(true);
        return repositorio.save(objcli);
    }
}