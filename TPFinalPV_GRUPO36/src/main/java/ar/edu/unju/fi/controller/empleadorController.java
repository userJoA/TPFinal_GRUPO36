package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;



@RequestMapping("/empleador")
@Controller
public class empleadorController {
	@Autowired 
	IEmpleadorService empleadorService;
	
	private static final Log LOGGER = LogFactory.getLog(empleadorController.class);
	
	/* LISTA */
	@GetMapping("/lista")
	public String getListaEmpleador(Model model) {
		model.addAttribute("empleadores",empleadorService.listaEmpleador() );
		LOGGER.info("redirigiendo a lista de empleadores");
		return "/empleador/lista_empleador";
	}
	
	
	/* AGREGAR EMPLEADOR */
	
	@GetMapping("/formulario")
	public String getPageForm(Model model) {
		model.addAttribute("empleador",empleadorService.getEmpleador());
		LOGGER.info("redirigiendo al formulario de alta");
		return "/empleador/form_empleador_alta";
	}
	
	@PostMapping("/guardar")
	public ModelAndView saveEmpleador(@ModelAttribute ("empleador") Empleador empleador) {
		ModelAndView mav= new ModelAndView("redirect:/empleador/lista");
		empleadorService.saveEmpleador(empleador);
		LOGGER.info("Se agrego un nuevo empleador a la lista");
		return mav;
	}
	
	/* MODIFICAR */
	
	@GetMapping("/modificar/{id}")
	public String getFormEdit(@PathVariable ("id") Long id,  Model model) {
		model.addAttribute("empleador",empleadorService.buscarPorId(id));
		LOGGER.info("Redirigiendo a formulario de edicion");
		return "/empleador/form_empleador_edit";
	}
	
	@PostMapping("/modificar")
	public ModelAndView editEmpleador(@ModelAttribute ("empleador") Empleador empleador) {
		ModelAndView mav = new ModelAndView("redirect:/empleador/lista");
		empleadorService.modificarEmpleador(empleador);
		mav.addObject("empleadores", empleadorService.listaEmpleador());
		LOGGER.info("Se ha modificado un empleador");
		return mav;
	}
	
	
	/* MODIFICAR */
	
	@GetMapping("/eliminar/{id}")
	public String deleteEmpleador(@PathVariable ("id") Long id,Model model) {
		empleadorService.eliminarEmpleador(id);
		LOGGER.info("Se ha eliminado un empleador");
		model.addAttribute("empleadores",empleadorService.listaEmpleador());
		return "/empleador/lista_empleador";
		
	}
	
	
	
	
}
