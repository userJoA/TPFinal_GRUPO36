package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.ICursoRepository;
import ar.edu.unju.fi.service.ICursoService;

public class CursoServiceImp implements ICursoService {

	@Autowired
	ICursoRepository cursoRepositoryImp;
	
	@Override
	public void guardarCurso(Curso curso) {
		cursoRepositoryImp.save(curso);
		
	}

	@Override
	public Curso obtenerCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public List<Curso> obtenerCursos() {
		// TODO Auto-generated method stub
		return cursoRepositoryImp.obtenerCursos();
	}
	

}
