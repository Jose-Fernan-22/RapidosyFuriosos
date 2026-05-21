package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;
import pe.com.rapidosyfuriosos.service.EmpleadoService;
import pe.com.rapidosyfuriosos.service.RolService;
import pe.com.rapidosyfuriosos.service.SexoService;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService servicio;
	
	@Autowired
	private DistritoService serviciodis;
	
	@Autowired
	private TipoDocumentoService serviciotipd;
	
	@Autowired
	private SexoService serviciosex;
	
	@Autowired
	private RolService serviciorol;
	
	//rutas
	//creamos una ruta para listar empleado
	@GetMapping("/empleado/listar")
	public String MostrarListarEmpleado(Model modelo) {
		modelo.addAttribute("listarempleado",servicio.findAllCustom());
		return "empleado/listarempleado";
	}
	
	@GetMapping("/empleado/registro")
	public String MostrarRegistrarEmpleado(Model modelo) {
		modelo.addAttribute("listardistrito",serviciodis.findAll());
		modelo.addAttribute("listartipodocumento",serviciotipd.findAll());
		modelo.addAttribute("listarsexo",serviciosex.findAll());
		modelo.addAttribute("listarrol",serviciorol.findAll());
		return "empleado/registrarempleado";
	}
	
	@GetMapping("/empleado/actualiza/{id}")
	public String MostrarActualizarEmpleado(Model modelo, @PathVariable Long id) {
		modelo.addAttribute("listardistrito",serviciodis.findAll());
		modelo.addAttribute("listartipodocumento",serviciotipd.findAll());
		modelo.addAttribute("listarsexo",serviciosex.findAll());
		modelo.addAttribute("listarrol",serviciorol.findAll());
		modelo.addAttribute("listarempleado",servicio.findById(id));
		return "empleado/actualizarempleado";
	}
	//creamos una ruta para habilitar empleado
	@GetMapping("/empleado/habilita")
	public String MostrarHabilitarEmpleado(Model modelo) {
		modelo.addAttribute("listarempleado",servicio.findAll());
		return "empleado/habilitarempleado";
	}
	//acciones de rutas
	//eliminar
	@GetMapping("/empleado/eliminar/{id}")
	public String EliminarEmpleado(@PathVariable Long id) {
		servicio.delete(id);
		return "redirect:/empleado/listar";
	}
	
	//habilitar
	@GetMapping("/empleado/habilitar/{id}")
	public String HabilitarEmpleado(@PathVariable Long id) {
		servicio.enable(id);
		return "redirect:/empleado/habilita";
	}
	
	//deshabilitar
		@GetMapping("/empleado/deshabilitar/{id}")
		public String DeshabilitarEmpleado(@PathVariable Long id) {
			servicio.delete(id);
			return "redirect:/empleado/habilita";
		}
	
	//creamos un modelo para pasar datos entre el contralador y la vista y tambien recibir
	//datos enviados desde el formulario
	@ModelAttribute("empleado")
	public EmpleadoEntity ModeloDistrito() {
		return new EmpleadoEntity();
	}
	
	//aciones de boton
	//registrar
	@PostMapping("/empleado/registrar")
	public String RegistrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity obj) {
		servicio.add(obj);
		return "redirect:/empleado/listar";
	}
	
	@PostMapping("/empleado/actualizar/{id}")
	public String ActualizarEmpleado(@ModelAttribute("empleado") EmpleadoEntity obj, @PathVariable Long id) {
		servicio.update(obj,id);
		return "redirect:/empleado/listar";
	}
	
	
}
