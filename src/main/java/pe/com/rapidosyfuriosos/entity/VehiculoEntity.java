package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name="VehiculoEntity")
@Table(name="vehiculo")
public class VehiculoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="codveh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name="plaveh", length = 10, nullable = false, unique = true)
    private String placa;
    
    @Column(name="modveh", length = 50, nullable = false)
    private String modelo;
    
    @Column(name="anioveh", nullable = false)
    private Integer anio;
 
    @Column(name="estveh", nullable = false)
    private Boolean estado;
    
    // Claves foráneas (Relaciones)
    @ManyToOne 
    @JoinColumn(name="codmar", nullable = false)
    private MarcaEntity marca;
    
    @ManyToOne 
    @JoinColumn(name="codcol", nullable = false)
    private ColorEntity color;
    
    @ManyToOne 
    @JoinColumn(name="codcli", nullable = false)
    private ClienteEntity cliente;
}