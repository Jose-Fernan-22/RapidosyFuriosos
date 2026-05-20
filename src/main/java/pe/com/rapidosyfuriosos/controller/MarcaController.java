package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.MarcaEntity;
import pe.com.rapidosyfuriosos.service.MarcaService;

@Controller
public class MarcaController {

    @Autowired
    private MarcaService servicio;

    // 1. Ruta para listar marcas habilitadas
    @GetMapping("/marca/listar")
    public String MostrarListarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAllCustom());
        return "marca/listarmarca";
    }
    
    // 2. Ruta para mostrar el formulario de registro
    @GetMapping("/marca/registro")
    public String MostrarRegistrarMarca() {
        return "marca/registrarmarca";
    }
    
    // 3. Ruta para mostrar el formulario de actualización
    @GetMapping("/marca/actualiza/{id}")
    public String MostrarActualizarMarca(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listamarca", servicio.findById(id));
        return "marca/actualizarmarca";
    }
    
    // 4. Ruta para mostrar la pantalla de habilitar/deshabilitar
    @GetMapping("/marca/habilita")
    public String MostrarHabilitarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAll());
        return "marca/habilitarmarca";
    }

    // ACCIONES DE RUTA (GET)
    
    // Eliminar (Deshabilitación lógica)
    @GetMapping("/marca/eliminar/{id}")
    public String EliminarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/listar";
    }
    
    // Habilitar desde la pantalla de gestión
    @GetMapping("/marca/habilitar/{id}")
    public String HabilitarMarca(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/marca/habilita";
    }
    
    // Deshabilitar desde la pantalla de gestión
    @GetMapping("/marca/deshabilitar/{id}")
    public String DeshabilitarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/habilita";
    }
    
    // Modelo global para compartir el objeto con el formulario de registro
    @ModelAttribute("marca")
    public MarcaEntity ModeloMarca() {
        return new MarcaEntity();
    }
    
    // ACCIONES DE BOTÓN (POST)
    
    // Registrar una nueva marca
    @PostMapping("/marca/registrar")
    public String RegistrarMarca(@ModelAttribute("marca") MarcaEntity obj) {
        servicio.add(obj);
        return "redirect:/marca/listar";
    }
    
    // Actualizar una marca existente
    @PostMapping("/marca/actualizar/{id}")
    public String ActualizarMarca(@ModelAttribute("marca") MarcaEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/marca/listar";
    }
}