package ar.edu.unju.fi.entity;

import java.time.LocalDate;

public class Empleador {
	private int cuit;
	private int contraseña;
	private String razon_social;
	private String nombre_comercial;
	private LocalDate inicio;
	private String email;
	private int telefono;
	private String direccion;
	private String provincia;
	private String pagina;
	private String descripcion;
	
	
	
	public Empleador() {
		super();
	}



	public int getCuit() {
		return cuit;
	}



	public void setCuit(int cuit) {
		this.cuit = cuit;
	}



	public int getContraseña() {
		return contraseña;
	}



	public void setContraseña(int contraseña) {
		this.contraseña = contraseña;
	}



	public String getRazon_social() {
		return razon_social;
	}



	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}



	public String getNombre_comercial() {
		return nombre_comercial;
	}



	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}



	public LocalDate getInicio() {
		return inicio;
	}



	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getPagina() {
		return pagina;
	}



	public void setPagina(String pagina) {
		this.pagina = pagina;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public String toString() {
		return "empleador [cuit=" + cuit + ", contraseña=" + contraseña + ", razon_social=" + razon_social
				+ ", nombre_comercial=" + nombre_comercial + ", inicio=" + inicio + ", email=" + email + ", telefono="
				+ telefono + ", direccion=" + direccion + ", provincia=" + provincia + ", pagina=" + pagina
				+ ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
	
}
