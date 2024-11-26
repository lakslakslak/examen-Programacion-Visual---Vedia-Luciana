package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.Alumno;
import ar.edu.unju.fi.service.AlumnoService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/Alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	//listar alumnos activos
	@GetMapping("/activos")
	public String listarActivos(Model model) {
		List<Alumno> alumnos = alumnoService.obtenerActivos();
		model.addAttribute("alumnos", alumnos);
		return "listar-alumnos";
	}
	
	//mostrar formulario de carga
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "formulario-alumno";
	}
	
	//guardar nuevo alumno
	@GetMapping("/guardar")
	public String guardarAlumno(@ModelAttribute Alumno alumno) {
		alumno.setEstado(true); //todos los nuevos estaran activos
		alumnoService.guardar(alumno);
		return "redirect:/alumnos/activos";
	}
	
	//editar alumno
	@GetMapping("/editar/{id}")
	public String editarAlumno(@PathVariable Integer id, Model model) {
		Alumno alumno = alumnoService.buscarPorId(id);
		if (alumno!= null) {
			model.addAttribute("alumno", alumno);
			return "formulario-alumno";
		}
		return "redirect:/alumnos/activos";
	}
	
	//eliminar alumno
	@GetMapping("/eliminar/{id}")
	public String eliminarAlumno(@PathVariable Integer id) {
		alumnoService.eliminarLogico(id);
		return "redirect:/alumnos/activos";
	}
}
