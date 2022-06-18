package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.ICiudadanoRepository;
import ar.edu.unju.fi.service.ICiudadanoService;
@Service
public class CiudadanoServiceImp implements ICiudadanoService {

	@Autowired
	ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public boolean guardarCiudadano(Ciudadano ciudadano) {
		/*
		 * ciudadano.setEstado(true); if(ciudadanoRepository.save(ciudadano) != null) {
		 * return true; } return false;
		 */
		ciudadanoRepository.save(ciudadano);
		return true;
		
	}

	@Override
	public List<Ciudadano> listaCiudadano() {
		return ciudadanoRepository.findAll();
	}

	@Override
	public Ciudadano modificarCiudadano(Ciudadano ciudadano) throws Exception {
		Ciudadano c= buscarPorId(ciudadano.getId());
		c.setDni(ciudadano.getDni());
		c.setEmail(ciudadano.getEmail());
		c.setEstado_civil(ciudadano.getEstado_civil());
		c.setNumero_tramite(ciudadano.getNumero_tramite());
		c.setProvincia(ciudadano.getProvincia());
		c.setTelefono(ciudadano.getTelefono());
		c.setFecha_nac(ciudadano.getFecha_nac());
	
		return ciudadanoRepository.save(c);

	}

	@Override
	public Ciudadano buscarCiudadanoPorDni(int dni) {
		return ciudadanoRepository.findByDni(dni);
	}
	
	@Override
	public void eliminarCiudadano(Long id) throws Exception {
		
		/*
		 * Optional<Ciudadano> ciudadano=ciudadanoRepository.findById(id);
		 * ciudadano.get().setEstado(false); ciudadanoRepository.save(ciudadano.get());
		 */
		 ciudadanoRepository.deleteById(id); 

	}
	
	@Override
	public Ciudadano obtenerCiudadano() {
		return new Ciudadano();
	}

	@Override
	public Ciudadano buscarPorId(Long id) throws Exception {
		return ciudadanoRepository.findById(id).orElseThrow(()-> new Exception("El ciudadano no existe") );
	}

}
