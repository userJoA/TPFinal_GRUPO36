package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.entity.Curso;

import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.util.ListaCurso;

@Service ("cursoServiceList")
public class CursoServiceImp implements ICursoService {

	
	@Autowired
	//ICursoRepository cursoRepositoryImp;
	ListaCurso cursos;
	
	//@Override
	//public Curso obtenerCurso() {
	// TODO Auto-generated method stub
	//	/return new Curso();
	//}

	@Override
	
	public ListaCurso listaCursos() {
		
		return cursos;
		
	}
	

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}
	public boolean guardarCandidato(Curso curso) {
		//agregar un candidato
		return ListaCurso.getCursos().add(curso);
	}
	

}
