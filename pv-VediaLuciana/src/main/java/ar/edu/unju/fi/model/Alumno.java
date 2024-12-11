package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;

	@Column(nullable = false, unique = true)
	private String dni;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private String curso;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@Column(nullable = false)
	private Boolean estado;

	// metodo para calcular edad
	public int calcularEdad() {
		return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
	}

}
