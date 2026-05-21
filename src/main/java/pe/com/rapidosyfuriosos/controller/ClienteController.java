package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.ClienteEntity;
import pe.com.rapidosyfuriosos.service.ClienteService;
import pe.com.rapidosyfuriosos.service.DistritoService;
import pe.com.rapidosyfuriosos.service.SexoService;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService servicio;
    
    @Autowired
    private DistritoService serviciodis;
    
    @Autowired
    private TipoDocumentoService serviciotipd;
    
    @Autowired
    private SexoService serviciosex;

    // 1. Mostrar Listado (Solo clientes habilitados)
    @GetMapping("/cliente/listar")
    public String MostrarListarCliente(Model modelo) {
        modelo.addAttribute("listarcliente", servicio.findAllCustom());
        return "cliente/listarcliente";
    }

    // 2. Mostrar Formulario de Registro
    @GetMapping("/cliente/registro")
    public String MostrarRegistrarCliente(Model modelo) {
        // Llenamos los combos (selects) solo con datos habilitados
        modelo.addAttribute("listardistrito", serviciodis.findAllCustom());
        modelo.addAttribute("listartipodocumento", serviciotipd.findAllCustom());
        modelo.addAttribute("listarsexo", serviciosex.findAllCustom());
        return "cliente/registrarcliente";
    }

    // 3. Mostrar Formulario de Actualización
    @GetMapping("/cliente/actualiza/{id}")
    public String MostrarActualizarCliente(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listardistrito", serviciodis.findAllCustom());
        modelo.addAttribute("listartipodocumento", serviciotipd.findAllCustom());
        modelo.addAttribute("listarsexo", serviciosex.findAllCustom());
        modelo.addAttribute("listarcliente", servicio.findById(id));
        return "cliente/actualizarcliente";
    }

    // 4. Mostrar Pantalla de Gestión de Estados
    @GetMapping("/cliente/habilita")
    public String MostrarHabilitarCliente(Model modelo) {
        modelo.addAttribute("listarcliente", servicio.findAll());
        return "cliente/habilitarcliente";
    }

    // --- ACCIONES DE RUTAS (GET) ---

    // Eliminar (Lógico)
    @GetMapping("/cliente/eliminar/{id}")
    public String EliminarCliente(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/cliente/listar";
    }

    // Habilitar
    @GetMapping("/cliente/habilitar/{id}")
    public String HabilitarCliente(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/cliente/habilita";
    }

    // Deshabilitar
    @GetMapping("/cliente/deshabilitar/{id}")
    public String DeshabilitarCliente(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/cliente/habilita";
    }

    // Modelo global para los formularios
    @ModelAttribute("cliente")
    public ClienteEntity ModeloCliente() {
        return new ClienteEntity();
    }

    // --- ACCIONES DE BOTONES (POST) ---

    // Registrar
    @PostMapping("/cliente/registrar")
    public String RegistrarCliente(@ModelAttribute("cliente") ClienteEntity obj) {
        servicio.add(obj);
        return "redirect:/cliente/listar";
    }

    // Actualizar
    @PostMapping("/cliente/actualizar/{id}")
    public String ActualizarCliente(@ModelAttribute("cliente") ClienteEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/cliente/listar";
    }
}