package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorRepository;
import ar.edu.unju.fi.service.IEmpleadorService;

@Service
public class EmpleadorServiceImp implements IEmpleadorService {
	
	@Autowired
	IEmpleadorRepository empleadorRepository;
	
	@Override
	public Empleador getEmpleador() {
		
		return new Empleador();
	}

	@Override
	public List<Empleador> listaEmpleador() {		
		return empleadorRepository.findAll();
	}

	@Override
	public boolean saveEmpleador(Empleador empleador) {
		empleadorRepository.save(empleador);
		return true;
	}

	@Override
	public void modificarEmpleador(Empleador empleador) {
		empleadorRepository.save(empleador);
	}

	@Override
	public void eliminarEmpleador(Long id) {
		empleadorRepository.deleteById(id);
	}

	@Override
	public Empleador buscarPorId(Long id) {
		Optional<Empleador> e= empleadorRepository.findById(id);
		return e.get();
	}
	
	
	

}
