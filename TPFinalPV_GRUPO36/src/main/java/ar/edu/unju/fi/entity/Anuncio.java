package ar.edu.unju.fi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "anuncios")
@Component
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "anu_id")
	private Long idAnuncio;
	
	@Positive(message = "Ingrese mayor o igual 1")
	@Column(name = "anu_vacante")
	private int vacantes;
	
	@NotBlank(message = "Ingrese nombre del puesto")
	@Column(name = "anu_nombre_puesto")
	private String nombreDePuesto;
	
	@Column(name = "anu_descripcion")
	private String descripcionPuesto;
	
	@Column(name = "anu_tiempoDisponible")
	private String tiempoDisponible;
	
	@NotBlank(message = "Ingrese, al menos, una función")
	@Column(name = "anu_funcion")
	private String funciones;
	
	@Min(value = 10000,message = "El salario debe ser mayor a 10000")
	@Column(name= "anu_salario")
	private Double salario;
	
	@Column(name ="anu_requisitos")
	private String requisitos;
	
	@Column(name = "anu_beneficios")
	private String beneficios;
	
	@Column(name = "anu_disponible")
	private boolean disponible;
	
	@Column(name = "anu_estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "Emp_ID")
	private Empleador empleador;
	
	@ManyToMany(mappedBy = "ofertas")
	private List<Ciudadano> ciudadanos;
	
	//private Contacto contacto;
	//private String jornada;
	
	
	public Anuncio() {
		super();
	}
	
	
	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}


	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}


	public Long getIdAnuncio() {
		return idAnuncio;
	}
	
	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	
	public int getVacantes() {
		return vacantes;
	}
	
	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	
	public String getNombreDePuesto() {
		return nombreDePuesto;
	}
	
	public void setNombreDePuesto(String nombreDePuesto) {
		this.nombreDePuesto = nombreDePuesto;
	}
	
	public String getDescripcionPuesto() {
		return descripcionPuesto;
	}
	
	public void setDescripcionPuesto(String descripcionPuesto) {
		this.descripcionPuesto = descripcionPuesto;
	}
	
	public String getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public void setTiempoDisponible(String tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}
	
	public String getFunciones() {
		return funciones;
	}
	
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public String getRequisitos() {
		return requisitos;
	}


	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}


	public String getBeneficios() {
		return beneficios;
	}
	
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Empleador getEmpleador() {
		return empleador;
	}


	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	
	
	
}
