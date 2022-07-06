package ar.edu.unju.fi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Ciudadano_Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "anu_id")
	private Anuncio anuncio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ciu_id")
	private Ciudadano ciudadano;

	
	
	
	
	public Ciudadano_Anuncio() {
		super();
	}



	public Ciudadano_Anuncio(Long id, Anuncio anuncio, Ciudadano ciudadano) {
		super();
		this.id = id;
		this.anuncio = anuncio;
		this.ciudadano = ciudadano;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Anuncio getAnuncio() {
		return anuncio;
	}



	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}



	public Ciudadano getCiudadano() {
		return ciudadano;
	}



	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	
	
	
	
	
}




