package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public List<Alumno> obtenerTodos(){
		return alumnoRepository.findAll();
	}

	public List<Alumno> obtenerActivos(){
		return alumnoRepository.findbyEstadoTrue();
	}	
	
	public Alumno guardar(Alumno alumno){
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
}
