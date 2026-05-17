package pe.com.rapidosyfuriosos.entity;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//@ -> significa anotacion
//Lombok-----------------------------------------------------
@NoArgsConstructor //metodo constructor vacio
@AllArgsConstructor //metodo constructo con parametros
@Data //metodos get y set,equals,hashcode y toString
@Builder// clase builder
//-----------------------------------------------------------
//Jakarta----------------------------------------------------
@Entity(name="DistritoEntity") //definir la entidad
@Table(name="distrito") //define la tabla con la que se trabaja
//-----------------------------------------------------------
//debemos de serializar la clase
public class DistritoEntity implements Serializable {
	//codigo de la serializacion
	private static final long serialVersionUID = 1L;
	
	//atributos de la clase
	@Id //define la clave primaria
	@Column(name="coddis") //define la coulmna con la que se relaciona
	@GeneratedValue(strategy = GenerationType.IDENTITY) //es para el auto_increment
	private Long codigo;
	@Column(name="nomdis", length = 50, nullable = false)
	private String nombre;
	@Column(name="estdis", nullable = false)
	private Boolean estado;
}
//falta completar
