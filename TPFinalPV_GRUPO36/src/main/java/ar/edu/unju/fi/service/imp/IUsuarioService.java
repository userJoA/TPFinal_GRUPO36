package ar.edu.unju.fi.service.imp;


import java.util.List;

import ar.edu.unju.fi.entity.Usuario;


public interface IUsuarioService {
	public void guardarUsuario(Usuario usuario);
	public Usuario getUsuario(String nombre);//busqueda por nombre
	//
	public void agregarUsuario(Usuario usuario);
	public List <Usuario> obtenerUsuarios();
	public Usuario getUser();

}
