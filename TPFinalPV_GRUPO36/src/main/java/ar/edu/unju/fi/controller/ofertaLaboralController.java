package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IAnuncioService;

@Controller
@RequestMapping("/oferta")
public class ofertaLaboralController {
	
	private static final Log LOGGER = LogFactory.getLog(AnuncioController.class);
	
	@Autowired
	IAnuncioService anuncioService;
	
	@GetMapping("/listado")
	public String getListaOfertasPage(Model model) {
		model.addAttribute("ofertas", anuncioService.listarAnuncio());
		return "/ciudadano/lista_ofertas_laborales";
	}

}
