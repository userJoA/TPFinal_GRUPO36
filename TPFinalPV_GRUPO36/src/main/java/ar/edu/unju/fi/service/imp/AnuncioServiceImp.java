package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Anuncio;
import ar.edu.unju.fi.repository.IAnuncioRepository;
import ar.edu.unju.fi.service.IAnuncioService;

@Service
public class AnuncioServiceImp implements IAnuncioService{

	@Autowired
	IAnuncioRepository anuncioRepository;
	
	@Override
	public Anuncio getAnuncio() {		
		return new Anuncio();
	}

	@Override
	public boolean guardarAnuncio(Anuncio anuncio) {
		if(anuncioRepository.save(anuncio) != null)
			return true;
		else
			return false;
	}

	@Override
	public Anuncio modificarAnuncio(Anuncio anuncio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarAnuncio(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Anuncio> listarAnuncio() {		
		return this.anuncioRepository.findAll();
	}

	@Override
	public Anuncio buscarPorId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
