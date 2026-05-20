package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;

@Controller
public class DistritoController {
		//inyeccion de dependencias al servicio
		@Autowired
		private DistritoService servicio;
		//rutas
		//creamos una ruta para listar distrito
		@GetMapping("/distrito/listar")
		//el objeto Model sirve para pasar datos hacia la vista (Thymeleaf)
		public String MostrarListarDistrito(Model modelo) {
			modelo.addAttribute("listadistrito",servicio.findAllCustom());
			return "distrito/listardistrito";
		}
		
		//creamos una ruta para registrar disrito
		@GetMapping("/distrito/registro")
		public String MostrarRegistrarDistrito() {
			return "distrito/registrardistrito";
		}
		
		//creamos una ruta para actualizar distrito
		//{id} -> es una variable de ruta
		@GetMapping("/distrito/actualiza/{id}")
		public String MostrarActualizarDistrito(Model modelo, @PathVariable Long id) {
			modelo.addAttribute("listadistrito",servicio.findById(id));
			return "distrito/actualizardistrito";
		}
		
		//creamos una ruta para habilitar distrito
		@GetMapping("/distrito/habilita")
		public String MostrarHabilitarDistrito(Model modelo) {
			modelo.addAttribute("listadistrito", servicio.findAll());
			return "distrito/habilitardistrito";
		}

		//acciones de rutas
		//eliminar
		@GetMapping("/distrito/eliminar/{id}")
		public String EliminarDistrito(@PathVariable Long id) {
			servicio.delete(id);
			return "redirect:/distrito/listar";
		}
		
		//habilitar
		@GetMapping("/distrito/habilitar/{id}")
		public String HabilitarDistrito(@PathVariable Long id) {
			servicio.enable(id);
			return "redirect:/distrito/habilita";
		}
		
		//habilitar
		@GetMapping("/distrito/deshabilitar/{id}")
		public String DeshabilitarDistrito(@PathVariable Long id) {
			servicio.delete(id);
			return "redirect:/distrito/habilita";
		}
		
		//deshabilitar
		
		//creamos un modelo para pasar datos entre el contralador y la vista y tambien recibir
		//datos enviados desde el formulario
		@ModelAttribute("distrito")
		public DistritoEntity ModeloDistrito() {
			return new DistritoEntity();
		}
		
		//aciones de boton
		//registrar
		@PostMapping("/distrito/registrar")
		public String RegistrarDistrito(@ModelAttribute("distrito") DistritoEntity obj) {
			servicio.add(obj);
			return "redirect:/distrito/listar";
		}
		
		//actualizar
		@PostMapping("/distrito/actualizar/{id}")
		public String ActualizarDistrito(@ModelAttribute("distrito") DistritoEntity obj,
				@PathVariable Long id) {
			servicio.update(obj,id);
			return "redirect:/distrito/listar";
		}


}
