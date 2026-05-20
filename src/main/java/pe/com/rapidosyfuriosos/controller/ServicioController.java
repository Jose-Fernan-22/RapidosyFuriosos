package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.ServicioEntity;
import pe.com.rapidosyfuriosos.service.ServicioService;

@Controller
public class ServicioController {

    @Autowired
    private ServicioService servicio;

    // 1. Ruta para listar servicios habilitados
    @GetMapping("/servicio/listar")
    public String MostrarListarServicio(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAllCustom());
        return "servicio/listarservicio";
    }
    
    // 2. Ruta para mostrar el formulario de registro
    @GetMapping("/servicio/registro")
    public String MostrarRegistrarServicio() {
        return "servicio/registrarservicio";
    }
    
    // 3. Ruta para mostrar el formulario de actualización
    @GetMapping("/servicio/actualiza/{id}")
    public String MostrarActualizarServicio(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listaservicio", servicio.findById(id));
        return "servicio/actualizarservicio";
    }
    
    // 4. Ruta para mostrar la pantalla de gestión de estados
    @GetMapping("/servicio/habilita")
    public String MostrarHabilitarServicio(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAll());
        return "servicio/habilitarservicio";
    }

    // ACCIONES DE RUTA (GET)
    
    @GetMapping("/servicio/eliminar/{id}")
    public String EliminarServicio(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/servicio/listar";
    }
    
    @GetMapping("/servicio/habilitar/{id}")
    public String HabilitarServicio(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/servicio/habilita";
    }
    
    @GetMapping("/servicio/deshabilitar/{id}")
    public String DeshabilitarServicio(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/servicio/habilita";
    }
    
    // Modelo global para el formulario de registro
    @ModelAttribute("servicio")
    public ServicioEntity ModeloServicio() {
        return new ServicioEntity();
    }
    
    // ACCIONES DE BOTÓN (POST)
    
    @PostMapping("/servicio/registrar")
    public String RegistrarServicio(@ModelAttribute("servicio") ServicioEntity obj) {
        servicio.add(obj);
        return "redirect:/servicio/listar";
    }
    
    @PostMapping("/servicio/actualizar/{id}")
    public String ActualizarServicio(@ModelAttribute("servicio") ServicioEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/servicio/listar";
    }
}