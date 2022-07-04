package ar.edu.unju.fi.service.imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorRepository;
import ar.edu.unju.fi.service.IEmpleadorService;

@Service("EmpleadorService")
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
		
		String pw = empleador.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		empleador.setPassword(bCryptPasswordEncoder.encode(pw));
		empleador.setTipo("tipoEmpleador");
		empleador.setName(empleador.getCuit());
		empleadorRepository.save(empleador);
		return true;
	}

	

	@Override
	public void eliminarEmpleador(Long id) {
		empleadorRepository.deleteById(id);
	}

	@Override
	public Empleador buscarPorId(Long id) throws Exception {
		return empleadorRepository.findById(id).orElseThrow(()-> new Exception("El Empleador no existe") );
	}

	@Override
	public Empleador modificarEmpleador(Empleador empleador) throws Exception{

		  Empleador emp= buscarPorId(empleador.getId());
		  emp.setDescripcion(empleador.getDescripcion());
		  emp.setDireccion(empleador.getDireccion());
		  emp.setEmail(empleador.getEmail()); 
		  emp.setPagina(empleador.getPagina());
		  emp.setInicio(empleador.getInicio());
		  emp.setNombre_comercial(empleador.getNombre_comercial());
		  emp.setProvincia(empleador.getProvincia());
		  emp.setTelefono(empleador.getTelefono());
		  emp.setRazon_social(empleador.getRazon_social());
		return empleadorRepository.save(emp);
	}

	@Override
	public Empleador buscarPorDni(Long cuit) throws Exception {
		return empleadorRepository.findByDni(cuit).orElseThrow(()-> new Exception("El Empleador no existe") );
	}
	
	
	

}
