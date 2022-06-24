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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Anuncio;
import ar.edu.unju.fi.service.IAnuncioService;

@Controller
@RequestMapping("/anuncio")
public class AnuncioController {
	
	private static final Log LOGGER = LogFactory.getLog(AnuncioController.class);
	
	@Autowired
	IAnuncioService anuncioService;
	
	@GetMapping("/nuevo")
	public String getFormOferta(Model model) {
		model.addAttribute("anuncio", anuncioService.getAnuncio());
		return "empleador/form_oferta_laboral_alta";
	}
	
	@PostMapping("/formulario")
	public ModelAndView agregarAnuncio(@Validated @ModelAttribute("anuncio") Anuncio anuncio, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("/empleador/form_oferta_laboral_alta");
			mav.addObject("anuncio", anuncio);
			return mav;
		}
		anuncioService.guardarAnuncio(anuncio);
		LOGGER.info("se agrego un nuevo anuncio");
		ModelAndView mav = new ModelAndView("/empleador/lista_ofertas_laborales");
		mav.addObject("ofertas", anuncioService.listarAnuncio());
		LOGGER.info("Redirigiendo a lista de ofertas");
		return mav;
	}
	
	@GetMapping("/lista")
	public String getListaOfertasPage(Model model) {
		model.addAttribute("ofertas", anuncioService.listarAnuncio());
		return "/empleador/lista_ofertas_laborales";
	}

	@GetMapping("/eliminar/{idAnuncio}")
	public String eliminarAnuncio(@PathVariable("idAnuncio") Long id, Model model) throws Exception {
		this.anuncioService.eliminarAnuncio(id);
		LOGGER.info("Se eliminó el anuncio de la lista");
		model.addAttribute("ofertas", this.anuncioService.listarAnuncio());
		return "/empleador/lista_ofertas_laborales";
	}
	
}
