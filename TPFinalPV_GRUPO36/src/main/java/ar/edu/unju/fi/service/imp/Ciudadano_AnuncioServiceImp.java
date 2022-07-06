package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano_Anuncio;
import ar.edu.unju.fi.repository.ICiudadano_AnuncioRepository;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICiudadano_AnuncioService;

@Service
public class Ciudadano_AnuncioServiceImp implements ICiudadano_AnuncioService {
	@Autowired
	private ICiudadano_AnuncioRepository ciudadano_anuncioRepository;
	
	@Autowired
	private ICiudadanoService ciudadanoService; 
	
	@Override
	public Ciudadano_Anuncio obtenerCiudadanoAnuncio() {
		// TODO Auto-generated method stub
		return new Ciudadano_Anuncio();
	}

	@Override
	public void guardarCiudadanoAnuncio(Ciudadano_Anuncio ciudadano_anuncio) {
		ciudadano_anuncioRepository.save(ciudadano_anuncio);
		
	}

	@Override
	public void eliminarCiudadanoAnuncio(Ciudadano_Anuncio ciudadano_anuncio) {
		// TODO Auto-generated method stub
		ciudadano_anuncioRepository.delete(ciudadano_anuncio);
	}

	@Override
	public void editarCiudadanoAnuncio(Ciudadano_Anuncio ciudadano_anuncio) {
	

	}

	@Override
	public List<Ciudadano_Anuncio> listaCiudadano_Anuncio() {
		// TODO Auto-generated method stub
		return (List<Ciudadano_Anuncio>) ciudadano_anuncioRepository.findAll();
	}

	@Override
	public Ciudadano_Anuncio buscarCiudadanoAnuncio(Long id) {
		// TODO Auto-generated method stub
		//return ciudadano_anuncioRepository.findById(id);
		return null;
	}

	@Override
	public boolean verificacionCiudadanoAnuncio(Long id_ciudadano, Long id_anuncio) {
		boolean verificacion= true;
		
		for(Ciudadano_Anuncio ciudadanoanuncio : ciudadano_anuncioRepository.findAll()) {
			if (ciudadanoanuncio.getCiudadano().getId()==id_anuncio) {
				if(ciudadanoanuncio.getAnuncio().getIdAnuncio()==id_anuncio) {
					verificacion=false;	
				}
			}
		}
		
		return verificacion;
	}

}
