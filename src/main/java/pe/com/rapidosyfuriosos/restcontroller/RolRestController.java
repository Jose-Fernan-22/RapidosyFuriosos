package pe.com.rapidosyfuriosos.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.rapidosyfuriosos.entity.RolEntity;
import pe.com.rapidosyfuriosos.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolRestController {

    @Autowired
    private RolService servicio;

    @GetMapping
    public List<RolEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<RolEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public RolEntity findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public RolEntity add(@RequestBody RolEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{id}")
    public RolEntity update(@RequestBody RolEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public RolEntity delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PatchMapping("/{id}")
    public RolEntity enable(@PathVariable Long id) {
        return servicio.enable(id);
    }
}