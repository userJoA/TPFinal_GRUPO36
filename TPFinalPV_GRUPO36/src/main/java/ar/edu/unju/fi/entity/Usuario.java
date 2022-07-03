package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

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
	@Column(name = "usu_msg")
private String menssge;
	
	
	public String getMenssge() {
		return menssge;
	}

	public void setMenssge(String menssge) {
		this.menssge = menssge;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long id, String usuario, String menssge) {
		super();
		this.id = id;
		this.menssge = menssge;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
