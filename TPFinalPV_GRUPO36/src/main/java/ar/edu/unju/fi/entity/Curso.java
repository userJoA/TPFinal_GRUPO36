package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;




@Component
@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "CODIGO", nullable = true)
	//@Min(value=1, message="El valor mínimo es 1") @Max(value=9999,message="El valor máximo permitido es 9999")
	private int codigo;
	
	//@Column(name = "TITULO")
	//@NotEmpty(message="El título no puede ser vacío")
	private String titulo;
	
	//@Column(name = "FECHAINICIO")
	//@NotNull @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaInicio;
	
	//@Column(name = "FECHAFINAL")
	//@NotNull @Future(message="La fecha debe ser posterior a la actual")
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaFinal;
	
	//@Column(name = "CANTIDADHORA")
	//@Min(value=1,message="Cantidad de horas debe ser mayor a 1")
	private int cantidadHoras;
	
	//@Column(name = "MODALIDAD")
	//@NotEmpty(message="Modalidad no puede ser vacío")
	private String modalidad;
	
	//@Autowired
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name ="LEGAJO")
	//@NotNull(message="Debe seleccionar un docente")
	//private Docente docente;
	
	//@Column(name = "CATEGORIA")
	//@NotEmpty(message="Categoría no puede ser vacío")
	private String categoria;
	
	//@Column(name = "CUPO")
	private int cupo;
	//
	//@Column(name ="DETALLE")
	private String detalle;
	//
	//
	@ManyToMany(mappedBy="cursos")
	private List<Ciudadano> ciudadanos;
	
	
	
	
	
	
	
	
	
	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}
	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	//public Docente getDocente() {
	//	return docente;
	//}
	//public void setDocente(Docente docente) {
	//	this.docente = docente;
	//}
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
	public Curso(int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFinal, int cantidadHoras,
			String modalidad, Docente docente, int cupo, String detalle) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		//this.docente = docente;
		
		this.cupo = cupo;
		this.detalle = detalle;
	}
	

	

	
}