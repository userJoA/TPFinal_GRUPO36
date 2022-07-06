package ar.edu.unju.fi.service;

import java.util.List;



import ar.edu.unju.fi.entity.Ciudadano_Anuncio;




public interface ICiudadano_AnuncioService {
	
	public Ciudadano_Anuncio obtenerCiudadanoAnuncio();
		
	public void guardarCiudadanoAnuncio(Ciudadano_Anuncio ciudadano_anuncio );
	
	public void eliminarCiudadanoAnuncio(Ciudadano_Anuncio ciudadano_anuncio);
	
	public void editarCiudadanoAnuncio(Ciudadano_Anuncio ciudadano_anuncio);
	
	public List<Ciudadano_Anuncio> listaCiudadano_Anuncio();
	
	public Ciudadano_Anuncio buscarCiudadanoAnuncio(Long id);
	
	public boolean verificacionCiudadanoAnuncio(Long id_ciudadano,Long id_anuncio);
	
}
