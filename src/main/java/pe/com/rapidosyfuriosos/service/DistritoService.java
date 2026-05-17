package pe.com.rapidosyfuriosos.service;

import java.util.List;

import pe.com.rapidosyfuriosos.entity.DistritoEntity;

public interface DistritoService {
	
	//declaramos las operaciones con las cuales vamos a trabajar
		//listar todo
		List<DistritoEntity> findAll();
		//listar solo los habilitados
		List<DistritoEntity> findAllCustom();
		//buscar por codigo
		DistritoEntity findById(Long id);
		//registrar
		DistritoEntity add(DistritoEntity obj);
		//actualizar
		DistritoEntity update(DistritoEntity obj,Long id);
		//eliminar
		DistritoEntity delete(Long id);
		//habilitar
		DistritoEntity enable(Long id);
}
