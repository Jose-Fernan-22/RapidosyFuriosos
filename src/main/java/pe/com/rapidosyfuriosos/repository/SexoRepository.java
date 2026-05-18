package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.SexoEntity;

public interface SexoRepository extends JpaRepository<SexoEntity, Long> {
    
    // Consulta SQL: select * from sexo where estsex=1
    @Query("select s from SexoEntity s where s.estado=true")
    List<SexoEntity> findAllCustom();
}