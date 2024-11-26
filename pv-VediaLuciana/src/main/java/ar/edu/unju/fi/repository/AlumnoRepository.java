package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	List<Alumno> findbyEstadoTrue(); //busca alumnos activos
}
