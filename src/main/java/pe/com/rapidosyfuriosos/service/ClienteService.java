package pe.com.rapidosyfuriosos.service;

import java.util.List;
import pe.com.rapidosyfuriosos.entity.ClienteEntity;

public interface ClienteService {
    List<ClienteEntity> findAll();
    List<ClienteEntity> findAllCustom();
    ClienteEntity findById(Long id);
    ClienteEntity add(ClienteEntity obj);
    ClienteEntity update(ClienteEntity obj, Long id);
    ClienteEntity delete(Long id);
    ClienteEntity enable(Long id);
}