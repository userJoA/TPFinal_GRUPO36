package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Curso;


@Repository
public interface ICursoRepository extends JpaRepository<Curso,Long>{
	
	public Curso findById(long id);

}
