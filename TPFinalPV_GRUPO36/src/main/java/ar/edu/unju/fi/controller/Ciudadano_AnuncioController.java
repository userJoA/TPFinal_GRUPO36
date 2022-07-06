package ar.edu.unju.fi.controller;

import java.lang.System.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Anuncio;
import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Ciudadano_Anuncio;
import ar.edu.unju.fi.service.IAnuncioService;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICiudadano_AnuncioService;

@Controller
@RequestMapping("/postular")
public class Ciudadano_AnuncioController {
	
	@Autowired
	private ICiudadano_AnuncioService ciudadano_anuncioService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IAnuncioService anuncioService;
	
	private static final Log LOGGER = LogFactory.getLog(Ciudadano_AnuncioController.class);
	
	
	@GetMapping("/nuevaPostulacion/{id_anuncio}")
	public ModelAndView postulacionCiudadano(@AuthenticationPrincipal User user,@PathVariable("id_anuncio")Long id_anuncio) throws  Exception {
		ModelAndView mav;
		Ciudadano postulante=ciudadanoService.buscarPorDni(Long.parseLong(user.getUsername()));
		if(postulante.getCurriculum()==null) {
			mav=new ModelAndView("layouts/no_Curriculum");
			LOGGER.error("No se ha creado ningun curriculum");
			return mav;
			
		}
		
		Ciudadano_Anuncio ciuAnu=ciudadano_anuncioService.obtenerCiudadanoAnuncio();
		
		if(	ciudadano_anuncioService.verificacionCiudadanoAnuncio(postulante.getId(), id_anuncio)){
			LOGGER.info("el usuario :  " + postulante.getEmail() + "Se ha postulado"  );
			Ciudadano copiaPostulante=ciudadanoService.buscarPorDni(Long.parseLong(user.getUsername()));
			ciuAnu.setCiudadano(copiaPostulante);
			Anuncio anuncio=anuncioService.buscarPorId(id_anuncio);
			ciuAnu.setAnuncio(anuncio);
			ciudadano_anuncioService.guardarCiudadanoAnuncio(ciuAnu);
			mav=new ModelAndView("layouts/Postulado");
			return mav;
			
			
		}else {
			LOGGER.error("El ciudadano ya esta postulado");
			mav=new ModelAndView("layouts/no_Postulado");
			return mav;
		}
		
		
		
	}
	
	
}
