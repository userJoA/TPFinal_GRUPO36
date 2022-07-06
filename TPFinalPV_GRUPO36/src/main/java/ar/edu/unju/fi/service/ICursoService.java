package ar.edu.unju.fi.service;


import java.util.List;

import ar.edu.unju.fi.entity.Curso;




public interface ICursoService {
	public boolean guardarCurso(Curso curso);
	public Curso getCurso();
	//public List<Curso> obtenerCursos();
	
	public Curso findById(long id);
	
	public List<Curso> getListaCursos();
	
}
