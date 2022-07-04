package ar.edu.unju.fi.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	@Qualifier("cursoServiceList")
	private ICursoService cursoService;
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	
	
	@SuppressWarnings("static-access")
	@Secured({"tipoCiudadano"})
	@GetMapping("/lista")
	public String getListaCurso(Model model) {
		model.addAttribute("cursos", cursoService.listaCursos().getCursos());
		LOGGER.info("Redirigiendo a al lista de cursos");
		LOGGER.info(model);
		return "/ciudadano/lista_curso";
		
	}
	
	
}
