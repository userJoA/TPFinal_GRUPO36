package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Ciudadano_Anuncio;


@Repository
public interface ICiudadano_AnuncioRepository extends JpaRepository<Ciudadano_Anuncio, Long> {
	 
}
