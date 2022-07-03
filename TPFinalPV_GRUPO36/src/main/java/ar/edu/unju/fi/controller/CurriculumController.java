package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.service.ICurriculumService;

@Controller
@RequestMapping("/cv")
public class CurriculumController {
	
	private static final Log LOGGER = LogFactory.getLog(CurriculumController.class);
	
	@Autowired
	ICurriculumService cvService;

	@GetMapping("/nuevo")
	public String getFormCV(Model model) {
		model.addAttribute("curriculum", cvService.getCv());
		//return "ciudadano/form_cv_alta";
		return "ciudadano/cv_ciudadano";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCV(@Validated @ModelAttribute("curriculum") Curriculum curriculum, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("/ciudadano/cv_ciudadano");
			mav.addObject("curriculum", curriculum);
			return mav;
		}
		ModelAndView mav = new ModelAndView("/ciudadano/portal_ciudadano");
		LOGGER.info("nuevo cv: "+curriculum.getEstudio());
		curriculum.fecharCreacionCV();
		if(this.cvService.guardarCv(curriculum))
			LOGGER.info("Se guardó curriculum");
		mav.addObject("curriculum", curriculum);
		return mav;
	}

//	@GetMapping("/vista")
//	public String mostrarCV(Model model) {
//		model.addAttribute("cvitae", "");
//		return "/ciudadano/portal_ciudadano";
//	}
	
}
