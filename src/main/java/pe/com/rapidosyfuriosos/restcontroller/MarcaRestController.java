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
import pe.com.rapidosyfuriosos.entity.MarcaEntity;
import pe.com.rapidosyfuriosos.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaRestController {

    @Autowired
    private MarcaService servicio;

    @GetMapping
    public List<MarcaEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<MarcaEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public MarcaEntity findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public MarcaEntity add(@RequestBody MarcaEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{id}")
    public MarcaEntity update(@RequestBody MarcaEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public MarcaEntity delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PatchMapping("/{id}")
    public MarcaEntity enable(@PathVariable Long id) {
        return servicio.enable(id);
    }
}