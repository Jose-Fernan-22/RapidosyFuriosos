package pe.com.rapidosyfuriosos.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Entity(name="EmpleadoEntity")
@Table(name="empleado")
public class EmpleadoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name="codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name="nomemp", length = 40, nullable = false)
    private String nombre;
    @Column(name="apepemp", length = 40, nullable = false)
    private String apellidopaterno;
    @Column(name="apememp", length = 40, nullable = false)
    private String apellidomaterno;
    @Column(name="docemp", length = 20, nullable = false)
    private String numerodocumento;
    @Column(name="fecemp", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechanacimiento;
    @Column(name="diremp", length = 300, nullable = false)
    private String dirreccion;
    @Column(name="telemp", length = 15, nullable = false)
    private String telefono;
    @Column(name="celemp", length = 15, nullable = false)
    private String celular;
    @Column(name="coremp", length = 100, nullable = false)
    private String correo;
    @Column(name="usuemp", length = 40, nullable = false)
    private String usuario;
    @Column(name="claemp", length = 225, nullable = false)
    private String clave;
    @Column(name="sueemp", nullable = false)
    private Double sueldo;
 
    @Column(name="estemp", nullable = false)
    private Boolean estado;
    
    //claves foraneas
    @ManyToOne //relacion de muchos a uno
    @JoinColumn(name="coddis",nullable = false)
    private DistritoEntity distrito;
    
    @ManyToOne 
    @JoinColumn(name="codrol",nullable = false)
    private RolEntity rol;
    
    @ManyToOne 
    @JoinColumn(name="codsex",nullable = false)
    private SexoEntity sexo;
    @ManyToOne 
    @JoinColumn(name="codtipd",nullable = false)
    private TipoDocumentoEntity tipodocumento;
}
