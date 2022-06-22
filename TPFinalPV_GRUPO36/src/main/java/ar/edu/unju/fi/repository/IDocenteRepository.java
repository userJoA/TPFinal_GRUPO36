package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Docente;

@Repository
public interface IDocenteRepository extends JpaRepository<Docente,Long>{
	@Query("from Docente d order by d.apellido")
	public List<Docente> obtenerDocentes();
	//public Docente  findByDocente(int legajo);


}
