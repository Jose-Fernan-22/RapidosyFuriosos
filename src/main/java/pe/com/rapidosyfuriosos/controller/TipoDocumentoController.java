package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Controller
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService servicio;

    // 1. Ruta para listar tipos de documento habilitados
    @GetMapping("/tipodocumento/listar")
    public String MostrarListarTipoDocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAllCustom());
        return "tipodocumento/listartipodocumento";
    }
    
    // 2. Ruta para mostrar el formulario de registro
    @GetMapping("/tipodocumento/registro")
    public String MostrarRegistrarTipoDocumento() {
        return "tipodocumento/registrartipodocumento";
    }
    
    // 3. Ruta para mostrar el formulario de actualización
    @GetMapping("/tipodocumento/actualiza/{id}")
    public String MostrarActualizarTipoDocumento(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listatipodocumento", servicio.findById(id));
        return "tipodocumento/actualizartipodocumento";
    }
    
    // 4. Ruta para mostrar la pantalla de gestión de estados (habilitar/deshabilitar)
    @GetMapping("/tipodocumento/habilita")
    public String MostrarHabilitarTipoDocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAll());
        return "tipodocumento/habilitartipodocumento";
    }

    // ACCIONES DE RUTA (GET)
    
    // Eliminar (Deshabilitación lógica)
    @GetMapping("/tipodocumento/eliminar/{id}")
    public String EliminarTipoDocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/listar";
    }
    
    // Habilitar desde la pantalla de gestión
    @GetMapping("/tipodocumento/habilitar/{id}")
    public String HabilitarTipoDocumento(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/tipodocumento/habilita";
    }
    
    // Deshabilitar desde la pantalla de gestión
    @GetMapping("/tipodocumento/deshabilitar/{id}")
    public String DeshabilitarTipoDocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/habilita";
    }
    
    // Modelo global para el formulario de registro
    @ModelAttribute("tipodocumento")
    public TipoDocumentoEntity ModeloTipoDocumento() {
        return new TipoDocumentoEntity();
    }
    
    // ACCIONES DE BOTÓN (POST)
    
    // Registrar un nuevo tipo de documento
    @PostMapping("/tipodocumento/registrar")
    public String RegistrarTipoDocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity obj) {
        servicio.add(obj);
        return "redirect:/tipodocumento/listar";
    }
    
    // Actualizar un tipo de documento existente
    @PostMapping("/tipodocumento/actualizar/{id}")
    public String ActualizarTipoDocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/tipodocumento/listar";
    }
}