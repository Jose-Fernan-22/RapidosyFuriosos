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
import pe.com.rapidosyfuriosos.entity.ColorEntity;
import pe.com.rapidosyfuriosos.service.ColorService;

@RestController
@RequestMapping("/api/color")
public class ColorRestController {

    @Autowired
    private ColorService servicio;

    @GetMapping
    public List<ColorEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ColorEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ColorEntity findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ColorEntity add(@RequestBody ColorEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{id}")
    public ColorEntity update(@RequestBody ColorEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public ColorEntity delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PatchMapping("/{id}")
    public ColorEntity enable(@PathVariable Long id) {
        return servicio.enable(id);
    }
}