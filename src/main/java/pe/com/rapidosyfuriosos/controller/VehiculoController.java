package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.VehiculoEntity;
import pe.com.rapidosyfuriosos.service.ClienteService;
import pe.com.rapidosyfuriosos.service.ColorService;
import pe.com.rapidosyfuriosos.service.MarcaService;
import pe.com.rapidosyfuriosos.service.VehiculoService;

@Controller
public class VehiculoController {

    @Autowired
    private VehiculoService servicio;
    
    @Autowired
    private MarcaService serviciomar;
    
    @Autowired
    private ColorService serviciocol;
    
    @Autowired
    private ClienteService serviciocli;

    // 1. Mostrar Listado (Solo vehículos habilitados)
    @GetMapping("/vehiculo/listar")
    public String MostrarListarVehiculo(Model modelo) {
        modelo.addAttribute("listarvehiculo", servicio.findAllCustom());
        return "vehiculo/listarvehiculo";
    }

    // 2. Mostrar Formulario de Registro
    @GetMapping("/vehiculo/registro")
    public String MostrarRegistrarVehiculo(Model modelo) {
        // Llenamos los combos solo con datos habilitados
        modelo.addAttribute("listarmarca", serviciomar.findAllCustom());
        modelo.addAttribute("listarcolor", serviciocol.findAllCustom());
        modelo.addAttribute("listarcliente", serviciocli.findAllCustom());
        return "vehiculo/registrarvehiculo";
    }

    // 3. Mostrar Formulario de Actualización
    @GetMapping("/vehiculo/actualiza/{id}")
    public String MostrarActualizarVehiculo(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarmarca", serviciomar.findAllCustom());
        modelo.addAttribute("listarcolor", serviciocol.findAllCustom());
        modelo.addAttribute("listarcliente", serviciocli.findAllCustom());
        modelo.addAttribute("listarvehiculo", servicio.findById(id));
        return "vehiculo/actualizarvehiculo";
    }

    // 4. Mostrar Pantalla de Gestión de Estados
    @GetMapping("/vehiculo/habilita")
    public String MostrarHabilitarVehiculo(Model modelo) {
        modelo.addAttribute("listarvehiculo", servicio.findAll());
        return "vehiculo/habilitarvehiculo";
    }

    // --- ACCIONES DE RUTAS (GET) ---

    // Eliminar (Lógico)
    @GetMapping("/vehiculo/eliminar/{id}")
    public String EliminarVehiculo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/vehiculo/listar";
    }

    // Habilitar
    @GetMapping("/vehiculo/habilitar/{id}")
    public String HabilitarVehiculo(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/vehiculo/habilita";
    }

    // Deshabilitar
    @GetMapping("/vehiculo/deshabilitar/{id}")
    public String DeshabilitarVehiculo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/vehiculo/habilita";
    }

    // Modelo global para los formularios
    @ModelAttribute("vehiculo")
    public VehiculoEntity ModeloVehiculo() {
        return new VehiculoEntity();
    }

    // --- ACCIONES DE BOTONES (POST) ---

    // Registrar
    @PostMapping("/vehiculo/registrar")
    public String RegistrarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity obj) {
        servicio.add(obj);
        return "redirect:/vehiculo/listar";
    }

    // Actualizar
    @PostMapping("/vehiculo/actualizar/{id}")
    public String ActualizarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/vehiculo/listar";
    }
}