package pe.com.rapidosyfuriosos.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.DistritoEntity;
public interface DistritoRepository extends JpaRepository<DistritoEntity, Long> {
	//agregar Query personalizado
	//consulta SQL: select * from distrito where estdis=1
	//creamos un query personalizado
	@Query("select d from DistritoEntity d where d.estado=true")
	List<DistritoEntity> findAllCustom();
}

