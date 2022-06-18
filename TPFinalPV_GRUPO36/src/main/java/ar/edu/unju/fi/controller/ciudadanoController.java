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

import ar.edu.unju.fi.entity.Ciudadano;

import ar.edu.unju.fi.service.ICiudadanoService;

@RequestMapping("/ciudadano")
@Controller
public class ciudadanoController {
	
	@Autowired
	ICiudadanoService ciudadanoService;
	
	private static final Log LOGGER = LogFactory.getLog(ciudadanoController.class);
	

	
	@GetMapping("/lista")
	public String getListaCiu(Model model) {
		model.addAttribute("ciudadanos", ciudadanoService.listaCiudadano());
		return "/ciudadano/lista_ciudadano";
	}
	
	/* AGREGAR CIUDADANO */
	
	@GetMapping("/formulario")
	public String getForm(Model model) {
		model.addAttribute("ciudadano",ciudadanoService.obtenerCiudadano());
		model.addAttribute("ciudadanos",ciudadanoService.listaCiudadano());
		return "/ciudadano/form_ciudadano_alta";
	}
	
	@PostMapping("/formulario")
	public ModelAndView agregarCiudadano(@Validated @ModelAttribute ("ciudadano") Ciudadano ciudadano,BindingResult bindingResult) {
		
			if(bindingResult.hasErrors()) {
				LOGGER.error("No se cumplen las reglas de validación");
				ModelAndView mav = new ModelAndView("/ciudadano/form_ciudadano_alta");
				mav.addObject("ciudadano", ciudadano);
				return mav;
			}
		
			ciudadanoService.guardarCiudadano(ciudadano);
			LOGGER.info("se agrego un nuevo ciudadano");
			ModelAndView mav= new ModelAndView("/ciudadano/lista_ciudadano");
			mav.addObject("ciudadanos",ciudadanoService.listaCiudadano());
			LOGGER.info("Redirigiendo a lista de ciudadanos");
			return mav;
	}
	
	/* MODIFICAR CIUDADANO */
	
	@GetMapping("/modificar/{id}")
	public String obtenerFormularioParaEditar(Model model, @PathVariable ("id") Long id) throws Exception  {
		Ciudadano ciudadanoEdit = ciudadanoService.buscarPorId(id);
		model.addAttribute("ciudadano", ciudadanoEdit);
		return "/ciudadano/form_ciudadano_edit";
	}
	
	@PostMapping("/modificar")
	public String modificarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano,Model model, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("ciudadano", ciudadano);
		}
		else {
			ciudadanoService.modificarCiudadano(ciudadano);
			LOGGER.info("se ha modificado un ciudadano de la lista");
			model.addAttribute("ciudadanos", ciudadanoService.listaCiudadano());	
		}
		
		return "/ciudadano/lista_ciudadano";
	}
	
	/* ELIMINAR */
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCiudadano(@PathVariable ("id") Long id, Model model) throws Exception {
		ciudadanoService.eliminarCiudadano(id);
		LOGGER.info("se ha eliminado un ciudadano de la lista");
		model.addAttribute("ciudadanos",ciudadanoService.listaCiudadano());
		return "/ciudadano/lista_ciudadano";
		
	}
	
	
}
