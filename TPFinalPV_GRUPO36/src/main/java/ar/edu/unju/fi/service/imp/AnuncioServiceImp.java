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
	public Anuncio modificarAnuncio(Anuncio anuncio) throws Exception{
		Anuncio elAnuncio = this.buscarPorId(anuncio.getIdAnuncio());		
		elAnuncio.setIdAnuncio(anuncio.getIdAnuncio());
		elAnuncio.setBeneficios(anuncio.getBeneficios());
		elAnuncio.setDescripcionPuesto(anuncio.getDescripcionPuesto());
		elAnuncio.setDisponible(anuncio.getDisponible());
		elAnuncio.setFunciones(anuncio.getFunciones());
		elAnuncio.setNombreDePuesto(anuncio.getNombreDePuesto());
		elAnuncio.setRequisitos(anuncio.getRequisitos());
		elAnuncio.setSalario(anuncio.getSalario());
		elAnuncio.setTiempoDisponible(anuncio.getTiempoDisponible());
		elAnuncio.setVacantes(anuncio.getVacantes());		
		return this.anuncioRepository.save(elAnuncio);
	}

	@Override
	public void eliminarAnuncio(Long id) throws Exception {
		this.anuncioRepository.deleteById(id);
	}

	@Override
	public List<Anuncio> listarAnuncio() {		
		return this.anuncioRepository.findAll();
	}

	@Override
	public Anuncio buscarPorId(Long id) throws Exception {		
		return this.anuncioRepository.findById(id).orElseThrow(()-> new Exception("Anuncio no existe") );
	}

}
