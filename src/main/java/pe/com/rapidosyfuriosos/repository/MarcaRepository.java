package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.MarcaEntity;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {
    
    // Consulta SQL: select * from marca where estmar=1
    @Query("select m from MarcaEntity m where m.estado=true")
    List<MarcaEntity> findAllCustom();
}