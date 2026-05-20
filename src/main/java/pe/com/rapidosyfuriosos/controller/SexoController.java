package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.SexoEntity;
import pe.com.rapidosyfuriosos.service.SexoService;

@Controller
public class SexoController {

    @Autowired
    private SexoService servicio;

    // 1. Ruta para listar sexos habilitados
    @GetMapping("/sexo/listar")
    public String MostrarListarSexo(Model modelo) {
        modelo.addAttribute("listasexo", servicio.findAllCustom());
        return "sexo/listarsexo";
    }
    
    // 2. Ruta para mostrar el formulario de registro
    @GetMapping("/sexo/registro")
    public String MostrarRegistrarSexo() {
        return "sexo/registrarsexo";
    }
    
    // 3. Ruta para mostrar el formulario de actualización
    @GetMapping("/sexo/actualiza/{id}")
    public String MostrarActualizarSexo(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listasexo", servicio.findById(id));
        return "sexo/actualizarsexo";
    }
    
    // 4. Ruta para mostrar la pantalla de gestión de estados (habilitar/deshabilitar)
    @GetMapping("/sexo/habilita")
    public String MostrarHabilitarSexo(Model modelo) {
        modelo.addAttribute("listasexo", servicio.findAll());
        return "sexo/habilitarsexo";
    }

    // ACCIONES DE RUTA (GET)
    
    // Eliminar (Deshabilitación lógica)
    @GetMapping("/sexo/eliminar/{id}")
    public String EliminarSexo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sexo/listar";
    }
    
    // Habilitar desde la pantalla de gestión
    @GetMapping("/sexo/habilitar/{id}")
    public String HabilitarSexo(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/sexo/habilita";
    }
    
    // Deshabilitar desde la pantalla de gestión
    @GetMapping("/sexo/deshabilitar/{id}")
    public String DeshabilitarSexo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sexo/habilita";
    }
    
    // Modelo global para el formulario de registro
    @ModelAttribute("sexo")
    public SexoEntity ModeloSexo() {
        return new SexoEntity();
    }
    
    // ACCIONES DE BOTÓN (POST)
    
    // Registrar un nuevo registro
    @PostMapping("/sexo/registrar")
    public String RegistrarSexo(@ModelAttribute("sexo") SexoEntity obj) {
        servicio.add(obj);
        return "redirect:/sexo/listar";
    }
    
    // Actualizar un registro existente
    @PostMapping("/sexo/actualizar/{id}")
    public String ActualizarSexo(@ModelAttribute("sexo") SexoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/sexo/listar";
    }
}