package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoService {
	
	public Ciudadano obtenerCiudadano();
	
	public boolean guardarCiudadano(Ciudadano ciudadano);
	
	public List<Ciudadano> listaCiudadano();
	
	public Ciudadano modificarCiudadano(Ciudadano ciudadano) throws Exception;
	
	public void eliminarCiudadano(Long id) throws Exception;
	
	//public Ciudadano buscarCiudadanoPorDni(int dni);
	
	public Ciudadano buscarPorId(Long id) throws Exception;
	
	public Ciudadano buscarPorDni(Long dni) throws Exception;
	
	
	
	
}
