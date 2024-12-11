package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepository;

	public List<Alumno> obtenerTodos() {
		return alumnoRepository.findAll();
	}

	public List<Alumno> obtenerActivos() {
		List<Alumno> alumnos = alumnoRepository.findAll();
		List<Alumno> alumnosActivos = alumnos.stream().filter(alumno -> alumno.getEstado()).toList();
		return alumnosActivos;
	}

	public Alumno guardar(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	public Alumno buscarPorId(Integer id) {
		return alumnoRepository.findById(id).orElse(null);
	}

	public void eliminarLogico(Integer Id) {
		Alumno alumno = buscarPorId(Id);
		if (alumno != null) {
			alumno.setEstado(false);
			alumnoRepository.save(alumno);
		}
	}

	public List<Curso> obtenerCursos() {
		return List.of(Curso.values());
	}
}
