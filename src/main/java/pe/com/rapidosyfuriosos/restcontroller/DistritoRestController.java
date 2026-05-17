package pe.com.rapidosyfuriosos.restcontroller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;
//API RESTful
@RestController
//definir la ruta
@RequestMapping("/api/distrito")
public class DistritoRestController {
	//inyeccion de dependencias hacia el servicio
	@Autowired
	private DistritoService servicio;
	
	//Consultas o busquedas -> @GetMapping
	//mostrar todos los distritos
	@GetMapping
	public List<DistritoEntity> findAll(){
		return servicio.findAll();
	}
	
	//mostrar los distritos habilitados
	@GetMapping("/custom")
	public List<DistritoEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	//buscar distrito por codigo
	//{id} -> variable de ruta
	@GetMapping("/{id}")
	public DistritoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	//registrar -> @PostMapping
	@PostMapping
	public DistritoEntity add(@RequestBody DistritoEntity obj) {
		return servicio.add(obj);
	}
	
	//actualizar -> @PutMapping
	@PutMapping("/{id}")
	public DistritoEntity update(@RequestBody DistritoEntity obj,@PathVariable Long id) {
		return servicio.update(obj,id);
	}
	
	//eliminar -> @DeleteMapping
	@DeleteMapping("/{id}")
	public DistritoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	//habilitar -> @PatchMapping
	@PatchMapping("/{id}")
	public DistritoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
	
}
