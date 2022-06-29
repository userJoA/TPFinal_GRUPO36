package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Anuncio;

public interface IAnuncioService {
	
	public Anuncio getAnuncio();
	
	public boolean guardarAnuncio(Anuncio anuncio);
	
	public Anuncio modificarAnuncio(Anuncio anuncio) throws Exception;
	
	public void eliminarAnuncio(Long id) throws Exception;
	
	public Anuncio buscarPorId(Long id) throws Exception;
	
	public List<Anuncio> listarAnuncio();
	
}