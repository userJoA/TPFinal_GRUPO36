package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Anuncio;
import ar.edu.unju.fi.entity.Ciudadano;


@Repository
public interface ICiudadanoRepository extends JpaRepository<Ciudadano,Long>{
	
	public List<Ciudadano> findByEstado(boolean estado);
	
	
	
	//public Ciudadano findByDni(int dni);
	
	
	public Optional<Ciudadano> findByName(Long name);
	
	public List<Ciudadano> findByOfertas(Anuncio anuncio);

}
