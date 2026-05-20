package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.ColorEntity;
import pe.com.rapidosyfuriosos.service.ColorService;

@Controller
public class ColorController {

    @Autowired
    private ColorService servicio;

    // 1. Ruta para listar colores habilitados
    @GetMapping("/color/listar")
    public String MostrarListarColor(Model modelo) {
        modelo.addAttribute("listacolor", servicio.findAllCustom());
        return "color/listarcolor";
    }
    
    // 2. Ruta para mostrar el formulario de registro
    @GetMapping("/color/registro")
    public String MostrarRegistrarColor() {
        return "color/registrarcolor";
    }
    
    // 3. Ruta para mostrar el formulario de actualización
    @GetMapping("/color/actualiza/{id}")
    public String MostrarActualizarColor(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listacolor", servicio.findById(id));
        return "color/actualizarcolor";
    }
    
    // 4. Ruta para mostrar la pantalla de gestión de estados (habilitar/deshabilitar)
    @GetMapping("/color/habilita")
    public String MostrarHabilitarColor(Model modelo) {
        modelo.addAttribute("listacolor", servicio.findAll());
        return "color/habilitarcolor";
    }

    // ACCIONES DE RUTA (GET)
    
    // Eliminar (Deshabilitación lógica)
    @GetMapping("/color/eliminar/{id}")
    public String EliminarColor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/color/listar";
    }
    
    // Habilitar desde la pantalla de gestión
    @GetMapping("/color/habilitar/{id}")
    public String HabilitarColor(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/color/habilita";
    }
    
    // Deshabilitar desde la pantalla de gestión
    @GetMapping("/color/deshabilitar/{id}")
    public String DeshabilitarColor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/color/habilita";
    }
    
    // Modelo global para el formulario de registro
    @ModelAttribute("color")
    public ColorEntity ModeloColor() {
        return new ColorEntity();
    }
    
    // ACCIONES DE BOTÓN (POST)
    
    // Registrar un nuevo color
    @PostMapping("/color/registrar")
    public String RegistrarColor(@ModelAttribute("color") ColorEntity obj) {
        servicio.add(obj);
        return "redirect:/color/listar";
    }
    
    // Actualizar un color existente
    @PostMapping("/color/actualizar/{id}")
    public String ActualizarColor(@ModelAttribute("color") ColorEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/color/listar";
    }
}