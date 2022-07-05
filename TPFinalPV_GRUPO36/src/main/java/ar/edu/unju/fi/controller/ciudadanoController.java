package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.service.IAnuncioService;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICurriculumService;

@RequestMapping("/ciudadano")
@Controller
public class ciudadanoController {

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private ICurriculumService curriculumService;
	
	@Autowired
	private IAnuncioService anuncioService;


	private static final Log LOGGER = LogFactory.getLog(ciudadanoController.class);

	//@GetMapping("/login")
	//public String getCiudadanoLoginPage() {
	///	return "/ciudadano/login_ciudadano";
	//}

	@GetMapping("/lista")
	public String getListaCiu(Model model) {
		model.addAttribute("ciudadanos", ciudadanoService.listaCiudadano());
		return "/ciudadano/lista_ciudadano";
	}

	/* AGREGAR CIUDADANO */

	@GetMapping("/formulario")
	public String getForm(Model model) {
		model.addAttribute("ciudadano", ciudadanoService.obtenerCiudadano());
		model.addAttribute("ciudadanos", ciudadanoService.listaCiudadano());
		
		return "/ciudadano/form_ciudadano_alta";
	}

	@PostMapping("/formulario")
	public ModelAndView agregarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("/ciudadano/form_ciudadano_alta");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}
		ciudadano.setEstado(true);
		ciudadanoService.guardarCiudadano(ciudadano);
		LOGGER.info("Method: /ciudadano/formulario/  Action:se agrego un nuevo ciudadano");
		ModelAndView mav = new ModelAndView("/ciudadano/lista_ciudadano");
		mav.addObject("ciudadanos", ciudadanoService.listaCiudadano());
		LOGGER.info("Redirigiendo a lista de ciudadanos");
		return mav;
	}

	/* MODIFICAR CIUDADANO */

	@GetMapping("/modificar/{id}")
	public String obtenerFormularioParaEditar(Model model, @PathVariable("id") Long id) throws Exception {
		Ciudadano ciudadanoEdit = ciudadanoService.buscarPorId(id);
		model.addAttribute("ciudadano", ciudadanoEdit);
		return "/ciudadano/form_ciudadano_edit";
	}

	@PostMapping("/modificar")
	public String modificarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano, Model model,
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("ciudadano", ciudadano);
		} else {
			ciudadanoService.modificarCiudadano(ciudadano);
			LOGGER.info("Method: /ciudadano/modificar/  Action:se ha modificado un ciudadano de la lista");
			model.addAttribute("ciudadanos", ciudadanoService.listaCiudadano());
		}

		return "/ciudadano/lista_ciudadano";
	}

	/* ELIMINAR */

	@GetMapping("/eliminar/{id}")
	public String eliminarCiudadano(@PathVariable("id") Long id, Model model) throws Exception {
		ciudadanoService.eliminarCiudadano(id);
		LOGGER.info("Method: /ciudadano/eliminar/{id}/  Action:se ha eliminado un ciudadano de la lista");
		model.addAttribute("ciudadanos", ciudadanoService.listaCiudadano());
		return "/ciudadano/lista_ciudadano";

	}

	
	/* INICIO CIUDADANO */
	  
	  @GetMapping("/inicio") 
	  public ModelAndView obtenerPaginaInicioCiudadano(@AuthenticationPrincipal User user) throws Exception{
		  ModelAndView mav=new ModelAndView("ciudadano/inicio_ciudadano"); 
		  Ciudadano ciudadano= ciudadanoService.buscarPorDni(Long.parseLong(user.getUsername()));
		  LOGGER.info("Method: /ciudadano/inicio/  Action:login : " + ciudadano.getEmail());
			  mav.addObject("ciudadano",ciudadano);
		  return mav; 
	  }
	  
	/*CREAR CV*/
	  @GetMapping("/altaCV")
	  public ModelAndView crearCV(@AuthenticationPrincipal User user) throws Exception {
		  ModelAndView mav=new ModelAndView("ciudadano/cv_ciudadano");
		  Ciudadano ciudadano= ciudadanoService.obtenerCiudadano();
		  ciudadano=ciudadanoService.buscarPorDni(Long.parseLong(user.getUsername()));
		  Curriculum cv= curriculumService.getCv();
		  mav.addObject("curriculum", cv);
		  mav.addObject("ciudadano", ciudadano);
		  LOGGER.info("Method: /ciudadano/altaCV/  Action:Redirigiendo al formulario de curriculum");
		  return mav;
	  }
	  
	  /*VER CV*/
	  @GetMapping("/verCV")
	  public ModelAndView verCV(@AuthenticationPrincipal User user) throws Exception {
		  Ciudadano ciudadano= ciudadanoService.obtenerCiudadano();
		  ciudadano=ciudadanoService.buscarPorDni(Long.parseLong(user.getUsername()));
		  ModelAndView mav=new ModelAndView("ciudadano/portal_ciudadano");
		  Curriculum cv =new Curriculum();
		  cv=ciudadano.getCurriculum();
		  LOGGER.info(cv.getCurso());
		  mav.addObject("curriculum", cv);
		  LOGGER.info("Method: /ciudadano/verCV/  Action:Se muestra el curriculum de: " + ciudadano.getEmail());
		  return mav;
		  
	  }
	  
	  /*VER OFERTAS LABORALES*/
	  
	  @GetMapping("/verAnuncios")
	      public ModelAndView verAnuncios(@AuthenticationPrincipal User user) throws Exception {
		  Ciudadano ciudadano= ciudadanoService.obtenerCiudadano();
		  ciudadano=ciudadanoService.buscarPorDni(Long.parseLong(user.getUsername()));
		  ModelAndView mav= new ModelAndView("ciudadano/lista_ofertas_laborales");
		  mav.addObject("ciudadano",ciudadano);
		  mav.addObject("ofertas", anuncioService.listarAnuncio());
		  LOGGER.info("Method: /ciudadano/verAnuncios/  Action: Se muestra una lista de ofertas Laborales");
		  return mav;
	  }
	  
	  
	  /*POSTULACION OFERTA LABORAL*/
	 
	  
	  @GetMapping("/postulacion/{id_ciu}/{id_anu}")
	  public ModelAndView postulacionAnuncio(@PathVariable ("id_ciu") Long id_ciu,@PathVariable ("id_anu") Long id_anu ) throws Exception {
		  Ciudadano ciudadano=ciudadanoService.buscarPorId(id_ciu);
		  Anuncio anuncio=anuncioService.buscarPorId(id_anu);
		  boolean postulacion=true;
		  for (Anuncio anu : ciudadano.getOfertas()) {
			  if(anu.getIdAnuncio()==id_anu)
				  postulacion=false;
				  
		  }
		  
		  if(postulacion==true) {
			  ciudadano.getOfertas().add(anuncio);
			  ciudadanoService.modificarCiudadano(ciudadano);
			  ModelAndView mav=new ModelAndView("layouts/postulacionExitosa");
			  LOGGER.info("Method: /ciudadano/postulacion/  Action: el usuario: " + ciudadano.getEmail() + " se ha postulado a una oferta laboral");
			  return mav;
		  }
		  else
		  {
			  ModelAndView mav = new ModelAndView("layouts/postulacionFallida");
			  LOGGER.info("Method: /ciudadano/postulacion/  Action: el usuario ya se encuentra postulado");
			  return mav;
		  }
		
		
	  }

}
