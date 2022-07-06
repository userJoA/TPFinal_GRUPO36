package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;





@Entity
@Table(name="curso")
@Component
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private long id;
	
	@Column(name = "TITULO")
	@NotEmpty(message="El título no puede ser vacío")
	private String titulo;
	
	@Column(name = "FECHAINICIO")
	@NotNull @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaInicio;
	
	@Column(name = "FECHAFINAL")
	@NotNull @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaFinal;
	
	@Column(name = "CANTIDAD_HORA")
	@Min(value=1,message="Cantidad de horas debe ser mayor a 1")
	private int cantidadHoras;
	
	@Column(name = "MODALIDAD")
	@NotEmpty(message="Modalidad no puede ser vacío")
	private String modalidad;
	
	
	@Column(name = "CATEGORIA")
	@NotEmpty(message="Categoría no puede ser vacío")
	private String categoria;
	
	@Column(name = "CUPO")
	private int cupo;
	
	@Column(name ="DETALLE")
	private String detalle;
	
	@ManyToMany(mappedBy="cursos")
	private List<Ciudadano> ciudadanos;
	
	@Column(name = "cur_estado")
	private boolean estado;
	



	


	public Curso(long id, @NotEmpty(message = "El título no puede ser vacío") String titulo,
			@NotNull @FutureOrPresent(message = "La fecha debe ser hoy o posterior") LocalDate fechaInicio,
			@NotNull @Future(message = "La fecha debe ser posterior a la actual") LocalDate fechaFinal,
			@Min(value = 1, message = "Cantidad de horas debe ser mayor a 1") int cantidadHoras,
			@NotEmpty(message = "Modalidad no puede ser vacío") String modalidad,
			@NotEmpty(message = "Categoría no puede ser vacío") String categoria, int cupo, String detalle,
			List<Ciudadano> ciudadanos, boolean estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.categoria = categoria;
		this.cupo = cupo;
		this.detalle = detalle;
		this.ciudadanos = ciudadanos;
		this.estado = estado;
	}


	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}


	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<Ciudadano> getCiudadano() {
		return ciudadanos;
	}


	public void setCiudadano(List<Ciudadano> ciudadano) {
		this.ciudadanos = ciudadano;
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public int getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Curso() {
		super();
	}
	
	@Override
	public String toString() {
		return "Curso [id=" + id +"titulo="+titulo+"fechaInicio="+fechaInicio+ "fechaFinal="+fechaFinal+"cantidadHoras="+cantidadHoras+"modalidad="+modalidad+"categoria="+categoria+"cupo="+cupo+"detalle="+detalle + "]";
	}

	
}