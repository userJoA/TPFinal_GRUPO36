package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.IAnuncioService;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;



@RequestMapping("/empleador")
@Controller
public class empleadorController {
	@Autowired 
	@Qualifier("EmpleadorService")
	private IEmpleadorService empleadorService;
	
	@Autowired
	private IAnuncioService anuncioService;
	
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	private static final Log LOGGER = LogFactory.getLog(empleadorController.class);
	
	@GetMapping("/login")
	public String getEmpleadorLoginPage() {
		return "/empleador/login_empleador";
	}
	
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
	public ModelAndView saveEmpleador(@Validated @ModelAttribute ("empleador") Empleador empleador,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("/empleador/form_empleador_alta");
			mav.addObject("empleador",empleador);
			return mav;
		}
		
		ModelAndView mav= new ModelAndView("/layouts/registroCorrecto");
		empleadorService.saveEmpleador(empleador);
		LOGGER.info("Se agrego un nuevo empleador a la lista");
		return mav;
	}
	
	/* MODIFICAR */
	
	@GetMapping("/modificar/{id}")
	public String getFormEdit(@PathVariable ("id") Long id,  Model model) throws Exception {
		Empleador empleadorEdit=empleadorService.buscarPorId(id);
		model.addAttribute("empleador",empleadorEdit);
		LOGGER.info("Redirigiendo a formulario de edicion");
		return "/empleador/form_empleador_edit";
	}
	
	@PostMapping("/modificar")
	public ModelAndView editEmpleador(@Validated @ModelAttribute ("empleador") Empleador empleador, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("/empleador/form_empleador_edit");
			LOGGER.error("no se cumplen las reglas de vlidacion");
			mav.addObject("empleador", empleador);
			return mav;
		}
		
		
		ModelAndView mav = new ModelAndView("redirect:/empleador/lista");
		empleadorService.modificarEmpleador(empleador);
		mav.addObject("empleadores", empleadorService.listaEmpleador());
		LOGGER.info("Se ha modificado un empleador");
		return mav;
	}
	
	
	/* ELIMINAR */
	
	@GetMapping("/eliminar/{id}")
	public String deleteEmpleador(@PathVariable ("id") Long id,Model model) {
		empleadorService.eliminarEmpleador(id);
		LOGGER.info("Se ha eliminado un empleador");
		model.addAttribute("empleadores",empleadorService.listaEmpleador());
		return "/empleador/lista_empleador";
		
	}
	
	
	/*INICIO EMPLEADOR*/
	@GetMapping("/inicio")
	public ModelAndView obtenerPaginaInicioEmpleador(@AuthenticationPrincipal User user) throws Exception {
		ModelAndView mav= new ModelAndView("empleador/inicio_empleador");
		Empleador emp= new Empleador();
		emp=empleadorService.buscarPorCuit(Long.parseLong(user.getUsername()));
		LOGGER.info("Method: obtenerPaginaInicioEmpleador | ACTION: El usuario : "+ emp.getEmail() + " ha iniciado sesion" );
		mav.addObject("empleador", emp);
		mav.addObject("anuncios", emp.getAnuncios());
		return mav;
		
	}
	
	
	/*ALTA ANUNCIO*/
	@GetMapping("/altaAnuncio")
	public ModelAndView crearAnuncio(@AuthenticationPrincipal User user) throws Exception {
		Empleador emp= new Empleador();
		emp=empleadorService.buscarPorCuit(Long.parseLong(user.getUsername()));
		ModelAndView mav= new ModelAndView("empleador/form_oferta_laboral_alta");
		Anuncio anuncio= anuncioService.getAnuncio();
		mav.addObject("anuncio", anuncio);
		 mav.addObject("empleador", emp); 
		return mav;
		
	}
	
	
	/*POSTULANTES*/
	
	@GetMapping("/verAnuncios")
	public ModelAndView verAnuncios(@AuthenticationPrincipal User user) throws  Exception {
		ModelAndView mav= new ModelAndView("empleador/lista_ofertas_laborales");
		Empleador emp= new Empleador();
		emp=empleadorService.buscarPorCuit(Long.parseLong(user.getUsername()));
		mav.addObject("ofertas",emp.getAnuncios());
		LOGGER.info("Method: verAnunciosPropios | ACTION: se muestra una lista de las ofertas ofrecidas y sus postulaciones" );
		return mav;
		
	}
	
	
	@GetMapping("/verPostulantes/{id_anuncio}")
	public ModelAndView verPostulantesDeUnAnuncio(@PathVariable ("id_anuncio") Long id_anuncio) throws Exception {
		ModelAndView mav=new ModelAndView("/empleador/postulantes_anuncio");
		mav.addObject("anuncio", anuncioService.buscarPorId(id_anuncio));
		mav.addObject("postulantes",ciudadanoService.ciudadanosXanuncio(anuncioService.buscarPorId(id_anuncio)));
		
		return mav;
	}
	
	
	
	
	
	
}
