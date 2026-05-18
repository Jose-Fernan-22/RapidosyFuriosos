package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.VehiculoEntity;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {
    
    // Consulta SQL: select * from vehiculo where estveh=1
    @Query("select v from VehiculoEntity v where v.estado=true")
    List<VehiculoEntity> findAllCustom();
}