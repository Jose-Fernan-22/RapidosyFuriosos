package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.ServicioEntity;

public interface ServicioRepository extends JpaRepository<ServicioEntity, Long> {
    
    // Consulta SQL: select * from servicio where estser=1
    @Query("select s from ServicioEntity s where s.estado=true")
    List<ServicioEntity> findAllCustom();
}