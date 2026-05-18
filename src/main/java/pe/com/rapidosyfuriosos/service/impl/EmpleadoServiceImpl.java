package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;
import pe.com.rapidosyfuriosos.repository.EmpleadoRepository;
import pe.com.rapidosyfuriosos.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	 @Autowired
	 private EmpleadoRepository repositorio;
	
	@Override
	public List<EmpleadoEntity> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public List<EmpleadoEntity> findAllCustom() {
		// TODO Auto-generated method stub
		return repositorio.findAllCustom();
	}

	@Override
	public EmpleadoEntity findById(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public EmpleadoEntity add(EmpleadoEntity obj) {
		// TODO Auto-generated method stub
		return repositorio.save(obj);
	}

	@Override
	public EmpleadoEntity update(EmpleadoEntity obj, Long id) {
		EmpleadoEntity objdis=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(objdis);
	}

	@Override
	public EmpleadoEntity delete(Long id) {
		EmpleadoEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}

	@Override
	public EmpleadoEntity enable(Long id) {
		EmpleadoEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}
	
	
	
}
