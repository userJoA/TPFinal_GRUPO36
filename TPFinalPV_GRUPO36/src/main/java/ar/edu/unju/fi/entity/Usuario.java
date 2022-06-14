package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USUARIO")
	private String usuario;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "TIPO")
	private String perfil;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long id, String usuario, String password, String perfil) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", perfil=" + perfil + "]";
	}
	
	
}
