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

import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;
import pe.com.rapidosyfuriosos.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoRestController {

		@Autowired
		private EmpleadoService servicio;
		
		@GetMapping
		public List<EmpleadoEntity> findAll(){
			return servicio.findAll();
		}
		
		@GetMapping("/custom")
		public List<EmpleadoEntity> findAllCustom(){
			return servicio.findAllCustom();
		}
		
		@GetMapping("/{id}")
		public EmpleadoEntity findById(@PathVariable Long id) {
			return servicio.findById(id);
		}
		
		@PostMapping
		public EmpleadoEntity add(@RequestBody EmpleadoEntity obj) {
			return servicio.add(obj);
		}
		
		@PutMapping("/{id}")
		public EmpleadoEntity update(@RequestBody EmpleadoEntity obj,@PathVariable Long id) {
			return servicio.update(obj,id);
		}
		
		@DeleteMapping("/{id}")
		public EmpleadoEntity delete(@PathVariable Long id) {
			return servicio.delete(id);
		}
		
		@PatchMapping("/{id}")
		public EmpleadoEntity enable(@PathVariable Long id) {
			return servicio.enable(id);
		}
}
