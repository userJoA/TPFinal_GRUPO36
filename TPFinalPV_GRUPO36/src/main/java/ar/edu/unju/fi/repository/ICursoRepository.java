package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.entity.Curso;


public interface ICursoRepository extends JpaRepository<Curso,Long>{
	
	@Query("from Curso c order by c.titulo")
	public List<Curso> obtenerCursos();
	public Curso findByCodigo(int codigo);

}
