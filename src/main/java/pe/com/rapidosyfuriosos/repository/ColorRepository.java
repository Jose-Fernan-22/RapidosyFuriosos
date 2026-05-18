package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.ColorEntity;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
    
    // Consulta SQL: select * from color where estcol=1
    @Query("select c from ColorEntity c where c.estado=true")
    List<ColorEntity> findAllCustom();
}