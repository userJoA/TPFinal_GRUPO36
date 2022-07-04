package ar.edu.unju.fi.entity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Entity
@Component
@PrimaryKeyJoinColumn(name="usu_id")
@Table(name="Ciudadano")
public class Ciudadano extends Usuario{
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_ciu")
	private Long id;
	
	@Min(value=10000000, message="Debe ser mayor a 1000000") 
	@Max(value=99999999,message="Debe ser menor a 99999999")
	@Column(name = "cuit_dni")
	private Long dni;
		
	@NotNull
	@PositiveOrZero
	@Column(name = "ciu_numeroTramite") 
	private int numero_tramite;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Email(message="Email no valido")
	@Column(name = "ciu_email") 
	private String email;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name = "ciu_estadoCivil") 
	private String estado_civil;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name = "ciu_provincia") 
	private String provincia;
	
	@Column(name = "ciu_telefono") 
	private Long telefono;
	
	@NotNull @Past(message="La fecha debe ser anterior")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ciu_fecha_nac")
	private LocalDate fecha_nac;
	
	
	//@NotEmpty(message="Este campo no puede estar vacio")
	//@Size(min=8,message = "la contraseña debe tener como minimo 8 caracteres")
	//@Column(name = "ciu_password") 
	//private String password;
	

	@Column(name = "ciu_estado") 
	private boolean estado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ciu_curriculum")
	private Curriculum curriculum;
	

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	
	
	public Ciudadano() {
		super();
	}
	public Ciudadano(Long id, int numero_tramite,String email,String estado_civil,String provincia,Long telefono,LocalDate fecha_nac, boolean estado) 
	{
		super();
		this.id = id;
		//this.dni = dni;
		this.numero_tramite = numero_tramite;
		this.email = email;
		this.estado_civil = estado_civil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fecha_nac = fecha_nac;
		//this.password = password;
		this.estado = estado;
		//this.tipo=tipo;
	}
	public Ciudadano(Long id,
			@NotEmpty(message = "Este campo no puede estar vacio") @Size(min = 8, message = "la contraseña debe tener como minimo 8 caracteres") String password,
			String tipo, Long name) {
		super(id, password, tipo, name);
		// TODO Auto-generated constructor stub
	}



	public Ciudadano(Long id,
			@NotEmpty(message = "Este campo no puede estar vacio") @Size(min = 8, message = "la contraseña debe tener como minimo 8 caracteres") String password,
			String tipo, Long name, Long id2,
			@Min(value = 10000000, message = "Debe ser mayor a 1000000") @Max(value = 99999999, message = "Debe ser menor a 99999999") Long dni,
			@NotNull @PositiveOrZero int numero_tramite,
			@NotEmpty(message = "Este campo no puede estar vacio") @Email(message = "Email no valido") String email,
			@NotEmpty(message = "Este campo no puede estar vacio") String estado_civil,
			@NotEmpty(message = "Este campo no puede estar vacio") String provincia, Long telefono,
			@NotNull @Past(message = "La fecha debe ser anterior") LocalDate fecha_nac, boolean estado,
			Curriculum curriculum, Usuario usuario) {
		super(id, password, tipo, name);
		id = id2;
		this.dni = dni;
		this.numero_tramite = numero_tramite;
		this.email = email;
		this.estado_civil = estado_civil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fecha_nac = fecha_nac;
		this.estado = estado;
		this.curriculum = curriculum;
		this.usuario = usuario;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	
	public Long getDni() {
		return dni;
	}



	public void setDni(Long dni) {
		this.dni = dni;
	}


	public boolean isEstado() {
		return estado;
	}




	public void setEstado(boolean estado) {
		this.estado = estado;
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





	




	public Long getTelefono() {
		return telefono;
	}



	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}



	public Curriculum getCurriculum() {
		return curriculum;
	}



	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}



	public LocalDate getFecha_nac() {
		return fecha_nac;
	}





	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}





	



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "ciudadano [numero_tramite=" + numero_tramite +"dni="+dni +", email=" + email + ", estado_civil="
				+ estado_civil + ", provincia=" + provincia + ", telefono=" + telefono + ", fecha_nac=" + fecha_nac
				+ "]";
	}
	

}
