package ar.edu.unju.fi.entity;


import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;




@Component
@Entity
@Table(name="docente")
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEGAJO", nullable = true)
	@Min(value = 1000,message = "El número de Legajo debe ser mayor a 1000")
	private int legajo;
	
	@Size(min=2, max=60, message="El(Los) Nombre(s) debe(n) tener entre 2 a 60 caracteres")
	@NotEmpty(message="Debe ingresar por lo menos un Nombre")
	@Column(name = "NOMBRE", nullable = true)
	private String nombre;
	
	@Size(min=2, max=60, message="El(Los) Apellido(s) debe(n) tener entre 3 a 60 caracteres")
	@NotEmpty(message="Debe ingresar por lo menos un apellido")
	@Column(name = "APELLIDO", nullable = true)
	private String apellido;
	
	@NotEmpty(message="El correo electrónico es requerido")
	@Email(message = "Correo no válido", regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
	@Column(name = "EMAIL", nullable = true)
	private String email;
	
	//@NotNull(message="Debe ingresar un nro de teléfono")
	//@Column(name = "TELEFONO", nullable = true)
	//private long telefono;
	
	//@OneToMany(mappedBy = "docente", cascade= CascadeType.ALL)
	//private List<Curso> cursos=new ArrayList<Curso>();
	
	public Docente() {
		super();
	}
	
	public Docente(int legajo, String nombre, String apellido, String email) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	public int getLegajo() {
		return legajo;
	}
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	//public List<Curso> getCursos() {
	//	return cursos;
	//}

	//public void setCursos(List<Curso> cursos) {
	//	this.cursos = cursos;
	//}

	@Override
	public String toString() {
		return "Docente [legajo=" + legajo +"nombre="+nombre+"apellido="+apellido+ "email="+email + "]";
	}

	
}
