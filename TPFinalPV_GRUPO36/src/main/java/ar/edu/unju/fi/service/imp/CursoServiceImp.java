package ar.edu.unju.fi.service.imp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.ICursoRepository;
import ar.edu.unju.fi.service.ICursoService;

@Service ("cursoServiceImp")
public class CursoServiceImp implements ICursoService {

	@Autowired
	private ICursoRepository cursoRepository;

	@Override
	public Curso findById(long id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id);
	}

	@Override
	public List<Curso> getListaCursos() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		if(cursoRepository.save(curso) != null)
			return true;
		else
			return false;
	}
	
	
	
//ListaCurso getListaCursos() Curso getCurso() buscarCurso(Long id)

}
