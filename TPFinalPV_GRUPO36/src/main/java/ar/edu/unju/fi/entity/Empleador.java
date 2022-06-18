package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Empleador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_emp")
	private Long id;
	
	
	@Column(name = "emp_cuit")
	private int cuit;
	
	@Column(name = "emp_password")
	private int password;
	
	@Column(name = "emp_razonSocial")
	private String razon_social;
	
	@Column(name = "emp_nombreComer")
	private String nombre_comercial;
	
	@Column(name = "emp_fechadeIncio")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicio;
	
	@Column(name = "emp_email")
	private String email;
	
	@Column(name = "emp_telefono")
	private int telefono;
	
	@Column(name = "emp_direccion")
	private String direccion;
	
	@Column(name = "emp_provincia")
	private String provincia;
	
	@Column(name = "emp_pagina")
	private String pagina;
	
	@Column(name = "emp_descripcion")
	private String descripcion;
	
	@Column(name = "emp_estado")
	private boolean estado;
	
	
	
	
	
	public Empleador() {
		super();
	}





	public Empleador(int cuit, int password, String razon_social, String nombre_comercial, LocalDate inicio,
			String email, int telefono, String direccion, String provincia, String pagina, String descripcion,
			boolean estado) {
		super();
		this.cuit = cuit;
		this.password = password;
		this.razon_social = razon_social;
		this.nombre_comercial = nombre_comercial;
		this.inicio = inicio;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.provincia = provincia;
		this.pagina = pagina;
		this.descripcion = descripcion;
		this.estado = estado;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public int getCuit() {
		return cuit;
	}





	public void setCuit(int cuit) {
		this.cuit = cuit;
	}





	public int getPassword() {
		return password;
	}





	public void setPassword(int password) {
		this.password = password;
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





	public boolean isEstado() {
		return estado;
	}





	public void setEstado(boolean estado) {
		this.estado = estado;
	}





	@Override
	public String toString() {
		return "Empleador [id=" + id + ", cuit=" + cuit + ", password=" + password + ", razon_social=" + razon_social
				+ ", nombre_comercial=" + nombre_comercial + ", inicio=" + inicio + ", email=" + email + ", telefono="
				+ telefono + ", direccion=" + direccion + ", provincia=" + provincia + ", pagina=" + pagina
				+ ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}


	
	

	
	
	
}
