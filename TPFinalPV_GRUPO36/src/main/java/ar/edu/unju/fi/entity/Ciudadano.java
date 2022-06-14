package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Ciudadano")
public class Ciudadano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_ciu")
	private Long id;
	
	private int dni;
	private int numero_tramite;
	private String email;
	private String estado_civil;
	private String provincia;
	private int telefono;
	private LocalDate fecha_nac;
	private int contraseña;
	
	
	
	
	
	public Ciudadano() {
		super();
	}





	public Ciudadano(int dni, int numero_tramite, String email, String estado_civil, String provincia, int telefono,
			LocalDate fecha_nac, int contraseña) {
		super();
		this.dni = dni;
		this.numero_tramite = numero_tramite;
		this.email = email;
		this.estado_civil = estado_civil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fecha_nac = fecha_nac;
		this.contraseña = contraseña;
	}





	public int getDni() {
		return dni;
	}





	public void setDni(int dni) {
		this.dni = dni;
	}





	public int getNumero_tramite() {
		return numero_tramite;
	}





	public void setNumero_tramite(int numero_tramite) {
		this.numero_tramite = numero_tramite;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getEstado_civil() {
		return estado_civil;
	}





	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}





	public String getProvincia() {
		return provincia;
	}





	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}





	public int getTelefono() {
		return telefono;
	}





	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}





	public LocalDate getFecha_nac() {
		return fecha_nac;
	}





	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}





	public int getContraseña() {
		return contraseña;
	}





	public void setContraseña(int contraseña) {
		this.contraseña = contraseña;
	}





	@Override
	public String toString() {
		return "ciudadano [dni=" + dni + ", numero_tramite=" + numero_tramite + ", email=" + email + ", estado_civil="
				+ estado_civil + ", provincia=" + provincia + ", telefono=" + telefono + ", fecha_nac=" + fecha_nac
				+ ", contraseña=" + contraseña + "]";
	}
	
	
	
	
	
	
}
