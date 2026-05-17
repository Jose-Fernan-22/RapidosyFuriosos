package pe.com.rapidosyfuriosos.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.repository.DistritoRepository;
import pe.com.rapidosyfuriosos.service.DistritoService;
//indicamos que es un servicio con @Service
@Service
public class DistritoServiceImpl implements DistritoService {
	
	//inyeccion de dependencia hacia el repositorio
	@Autowired
	private DistritoRepository repositorio;
	@Override
	public List<DistritoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<DistritoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public DistritoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public DistritoEntity add(DistritoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DistritoEntity update(DistritoEntity obj, Long id) {
		//buscar el valor que se va actualizar
		DistritoEntity objdis=repositorio.findById(id).get();
		//actualizamos los valores
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(objdis);
	}
	@Override
	public DistritoEntity delete(Long id) {
		//buscar el valor que se va actualizar
		DistritoEntity objdis=repositorio.findById(id).get();
		//cambiamos el estado
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}
	@Override
	public DistritoEntity enable(Long id) {
		//buscar el valor que se va actualizar
		DistritoEntity objdis=repositorio.findById(id).get();
		//cambiamos el estado
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}
}
