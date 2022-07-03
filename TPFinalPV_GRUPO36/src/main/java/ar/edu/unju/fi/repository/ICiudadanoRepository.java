package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;


@Repository
public interface ICiudadanoRepository extends JpaRepository<Ciudadano,Long>{
	
	public List<Ciudadano> findByEstado(boolean estado);
	
	@Query("delete from Ciudadano c where c.dni = ?1")
	public void deleteByDni(int dni);
	
	//public Ciudadano findByDni(int dni);
	
	
	public Optional<Ciudadano> findByDni(Long dni);

}
