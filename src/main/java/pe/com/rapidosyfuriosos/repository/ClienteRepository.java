package pe.com.rapidosyfuriosos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    
    // Consulta SQL: select * from cliente where estcli=1
    @Query("select c from ClienteEntity c where c.estado=true")
    List<ClienteEntity> findAllCustom();
}