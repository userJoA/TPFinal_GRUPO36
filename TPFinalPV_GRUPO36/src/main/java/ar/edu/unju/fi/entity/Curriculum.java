package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "curriculums")
public class Curriculum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private Long idCV;
	
	@Column(name = "cv_fecha_realizacion")
	private LocalDate fechaRealizacion;
	
	//@OneToOne(mappedBy = "curriculum", fetch = FetchType.LAZY)
	//private Ciudadano ciudadano;
	
	@OneToOne
	@JoinColumn(name = "CIU_ID")
	private Ciudadano ciudadano;
	
	//esto va en ciudadano
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ciu_curriculum")
//	private Curriculum curriculum;
	
	
//	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Item> experiencias = new ArrayList<Item>();
	
	@Column(name = "cv_estudio")
	@NotBlank(message = "Puede colocar porcentaje aprobado de la carrera o carrera en curso")
	private String estudio;
	
	@Column(name = "cv_curso")
	private String curso;
	
	@Column(name = "cv_trabajo")
	private String experienciaLaboral;
	
	@Column(name = "cv_conocimiento")
	private String conocimiento;
	
	@Column(name = "cv_presentacion")
	private String presentacion;

	
	public Curriculum() {
		super();
	}
	
	/**
	 * Procedimiento que fija fecha de creación del Curriculum
	 */
	public void fecharCreacionCV() {
		this.fechaRealizacion = LocalDate.now();
	}
	
	public Long getIdCV() {
		return idCV;
	}

	public void setIdCV(Long idCV) {
		this.idCV = idCV;
	}

	public LocalDate getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(LocalDate fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public String getConocimiento() {
		return conocimiento;
	}

	public void setConocimiento(String conocimiento) {
		this.conocimiento = conocimiento;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
}
