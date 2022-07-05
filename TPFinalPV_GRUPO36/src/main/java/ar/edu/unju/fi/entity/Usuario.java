package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.InheritanceType;



import org.springframework.stereotype.Component;


@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@Component
public abstract class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usu_id")
	private Long id;
	//@Min(value=10000000, message="Debe ser mayor a 1000000") 
	//@Max(value=99999999,message="Debe ser menor a 99999999")
	//@Column(name = "cuit_dni")
	//private Long dni;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=8,message = "la contraseña debe tener como minimo 8 caracteres")
	@Column(name = "usr_password") 
	private String password;
	
	@Column(name = "ciu_tipo") 
	private String tipo;
	
	@Column(name = "cuit_dni")
	private Long name;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario(Long id,
			@NotEmpty(message = "Este campo no puede estar vacio") @Size(min = 8, message = "la contraseña debe tener como minimo 8 caracteres") String password,
			String tipo, Long name) {
		super();
		this.id = id;
		this.password = password;
		this.tipo = tipo;
		this.name = name;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Long getName() {
		return name;
	}

	public void setName(Long name) {
		this.name = name;
	}
	
	
	
}
