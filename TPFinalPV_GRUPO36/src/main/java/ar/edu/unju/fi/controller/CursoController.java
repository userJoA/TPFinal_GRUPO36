package ar.edu.unju.fi.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	@Qualifier("cursoServiceImp")
	private ICursoService cursoService;
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	//@Autowired
	//private ICiudadanoService ciudadanoService;
	
	
	@GetMapping("/lista")
	public String getListaOfertasPage(Model model) {
		model.addAttribute("cursos",cursoService.getListaCursos() );
		LOGGER.info("lista de cursos");
		return "/ciudadano/lista_curso";
		
	}
	
	
	@GetMapping("/nuevo")
	public String getFormCurso(Model model) {
		model.addAttribute("curso", cursoService.getCurso());
		return "/ciudadano/form_curso_alta";
	}
	
	@PostMapping("/formulario")
	public ModelAndView agregarCurso(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("/ciudadano/form_curso_alta");//
			mav.addObject("curso", curso);
			return mav;
		}
		cursoService.guardarCurso(curso);
		LOGGER.info("se agrego un nuevo curso");
		ModelAndView mav = new ModelAndView("/");
		mav.addObject("cursos", cursoService.getListaCursos());
		LOGGER.info("Redirigiendo a lista de cursos");
		return mav;
	}
	
}
