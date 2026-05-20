package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.RolEntity;
import pe.com.rapidosyfuriosos.service.RolService;

@Controller
public class RolController {

    @Autowired
    private RolService servicio;

    // 1. Ruta para listar roles habilitados
    @GetMapping("/rol/listar")
    public String MostrarListarRol(Model modelo) {
        modelo.addAttribute("listarol", servicio.findAllCustom());
        return "rol/listarrol";
    }
    
    // 2. Ruta para mostrar el formulario de registro
    @GetMapping("/rol/registro")
    public String MostrarRegistrarRol() {
        return "rol/registrarrol";
    }
    
    // 3. Ruta para mostrar el formulario de actualización
    @GetMapping("/rol/actualiza/{id}")
    public String MostrarActualizarRol(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarol", servicio.findById(id));
        return "rol/actualizarrol";
    }
    
    // 4. Ruta para mostrar la pantalla de gestión de estados (habilitar/deshabilitar)
    @GetMapping("/rol/habilita")
    public String MostrarHabilitarRol(Model modelo) {
        modelo.addAttribute("listarol", servicio.findAll());
        return "rol/habilitarrol";
    }

    // ACCIONES DE RUTA (GET)
    
    // Eliminar (Deshabilitación lógica)
    @GetMapping("/rol/eliminar/{id}")
    public String EliminarRol(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/rol/listar";
    }
    
    // Habilitar desde la pantalla de gestión
    @GetMapping("/rol/habilitar/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/rol/habilita";
    }
    
    // Deshabilitar desde la pantalla de gestión
    @GetMapping("/rol/deshabilitar/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/rol/habilita";
    }
    
    // Modelo global para el formulario de registro
    @ModelAttribute("rol")
    public RolEntity ModeloRol() {
        return new RolEntity();
    }
    
    // ACCIONES DE BOTÓN (POST)
    
    // Registrar un nuevo rol
    @PostMapping("/rol/registrar")
    public String RegistrarRol(@ModelAttribute("rol") RolEntity obj) {
        servicio.add(obj);
        return "redirect:/rol/listar";
    }
    
    // Actualizar un rol existente
    @PostMapping("/rol/actualizar/{id}")
    public String ActualizarRol(@ModelAttribute("rol") RolEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/rol/listar";
    }
}