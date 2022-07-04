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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;

@Controller
public class MainController {
		
	//@GetMapping("/")
	//public String getPageHome() {
		
	//	return "Principal";
	//}
	private static final Log LOGGER = LogFactory.getLog(MainController.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired 
	@Qualifier("EmpleadorService")
	private IEmpleadorService empleadorService;
	
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "Principal";
	}
	
	
	/* REGISTRO CIUDADANO */
	
	@GetMapping("/alta/ciudadano")
	public String obtenerFormAltaCiudadano(Model model) {
		model.addAttribute("ciudadano", ciudadanoService.obtenerCiudadano());
		LOGGER.info("redirigiendo a formulario de alta de ciudadano");
		return "/ciudadano/form_ciudadano_alta";
	}
	
	@PostMapping("/alta/ciudadano")
	public ModelAndView altaCiudadano(@Validated @ModelAttribute ("ciudadano") Ciudadano ciudadano,BindingResult bindingResult) {
		
			if(bindingResult.hasErrors()) {
				LOGGER.error("No se cumplen las reglas de validación");
				ModelAndView mav = new ModelAndView("/ciudadano/form_ciudadano_alta");
				mav.addObject("ciudadano", ciudadano);
				return mav;
			}
		
			ciudadanoService.guardarCiudadano(ciudadano);
			LOGGER.info("se agrego un nuevo ciudadano");
			ModelAndView mav= new ModelAndView("/layouts/registroCorrecto");
			return mav;
	}
	
	
	/* REGISTRO EMPLEADOR */
	
	@GetMapping("/alta/empleador")
	public String obtenerFormAltaEmpleador(Model model) {
		model.addAttribute("empleador",empleadorService.getEmpleador());
		LOGGER.info("redirigiendo al formulario de alta");
		return "/empleador/form_empleador_alta";
	}
	
	@PostMapping("/alta/empleador")
	public ModelAndView AltaEmpleador(@Validated @ModelAttribute ("empleador") Empleador empleador,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("/empleador/form_empleador_alta");
			mav.addObject("empleador",empleador);
			return mav;
		}
		
		ModelAndView mav= new ModelAndView("/layouts/registroCorrecto");
		empleadorService.saveEmpleador(empleador);
		LOGGER.info("Se agrego un nuevo empleador");
		return mav;
	}
	
	
}
