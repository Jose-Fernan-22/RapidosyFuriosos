package pe.com.rapidosyfuriosos.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long> {
    
    // Consulta SQL: select * from rol where estrol=1
    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllCustom();
}