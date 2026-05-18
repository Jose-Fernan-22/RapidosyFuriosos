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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name="ServicioEntity")
@Table(name="servicio")
public class ServicioEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="codser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name="nomser", length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(name="desser", length = 300, nullable = false)
    private String descripcion;

    @Column(name="preser", nullable = false)
    private Double precio;
    
    @Column(name="estser", nullable = false)
    private Boolean estado;
}