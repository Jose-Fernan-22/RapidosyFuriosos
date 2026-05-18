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
@Entity(name="ColorEntity")
@Table(name="color")
public class ColorEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="codcol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name="nomcol", length = 30, nullable = false, unique = true)
    private String nombre;
    
    @Column(name="estcol", nullable = false)
    private Boolean estado;
}