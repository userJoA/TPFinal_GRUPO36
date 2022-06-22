package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import ar.edu.unju.fi.entity.Docente;

public interface IDocenteRepository {
	@Query("from Docente d order by d.apellido")
	public List<Docente> obtenerDocentes();
	public Docente  findByDocente(int legajo);


}
