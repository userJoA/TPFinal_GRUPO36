package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;

public class DocenteServiceImp implements IDocenteService {

	@Autowired
	IDocenteRepository docenteRepositoryImp;

	@Override
	public Docente obtenerDocente() {
		// TODO Auto-generated method stub
		return new Docente() ;
	}

	@Override
	public List<Docente> obtenerDocentes() {
		// TODO Auto-generated method stub
		return docenteRepositoryImp.obtenerDocentes();
	}
	
	

}
