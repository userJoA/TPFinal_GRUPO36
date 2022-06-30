package ar.edu.unju.fi.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="EMPLEADOR")
public class Empleador{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_emp")
	private Long id;
	
	
	@Column(name = "emp_cuit")
	private String cuit;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=8,message = "la contraseña debe tener como minimo 8 caracteres") 
	@Column(name = "emp_password")
	private String password;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name = "emp_razonSocial")
	private String razon_social;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name = "emp_nombreComer")
	private String nombre_comercial;
	
	@NotNull @Past(message="La fecha debe ser anterior")
	@Column(name = "emp_fechadeIncio")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicio;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Email(message="Email no valido")
	@Column(name = "emp_email")
	private String email;
	
	
	@Column(name = "emp_telefono")
	private int telefono;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name = "emp_direccion")
	private String direccion;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name = "emp_provincia")
	private String provincia;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name = "emp_pagina")
	private String pagina;
	
	
	@Column(name = "emp_descripcion")
	private String descripcion;
	
	
	
	@Column(name = "emp_estado")
	private boolean estado;
	
	@OneToMany(mappedBy="empleador")
	private List<Anuncio> ofertas = new ArrayList<Anuncio>();
	
	
	
	public Empleador() {
		super();
	}


	
	public Empleador(Long id, String cuit,
			String password,
			String razon_social,
			String nombre_comercial,
			LocalDate inicio,
			String email,
			int telefono,String direccion,
			String provincia,
			String pagina, String descripcion, boolean estado,
			List<Anuncio> ofertas) {
		super();
		this.id = id;
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
		this.ofertas = ofertas;
	}




	public Long getId() {
		return id;
	}



	public String getCuit() {
		return cuit;
	}





	public void setCuit(String cuit) {
		this.cuit = cuit;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
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


	


	public List<Anuncio> getOfertas() {
		return ofertas;
	}










	public void setOfertas(List<Anuncio> ofertas) {
		this.ofertas = ofertas;
	}










	@Override
	public String toString() {
		return "Empleador [id=" + id + ", cuit=" + cuit + ", password=" + password + ", razon_social=" + razon_social
				+ ", nombre_comercial=" + nombre_comercial + ", inicio=" + inicio + ", email=" + email + ", telefono="
				+ telefono + ", direccion=" + direccion + ", provincia=" + provincia + ", pagina=" + pagina
				+ ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

	



	
	
	
	
}
