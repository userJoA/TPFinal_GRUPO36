package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.repository.ICurriculumRepository;
import ar.edu.unju.fi.service.ICurriculumService;

@Service
public class CurriculumServiceImp implements ICurriculumService{

	@Autowired
	ICurriculumRepository cvRepository;	
	
	@Override
	public Curriculum getCv() {		
		return new Curriculum();
	}
	
	@Override
	public boolean guardarCv(Curriculum curriculum) {
		if(cvRepository.save(curriculum) != null)
			return true;
		else
			return false;
	}

	@Override
	public void modificarCv(Curriculum cv) {
		cvRepository.save(cv);
	}

	@Override
	public void eliminarCv(Long id) {
		cvRepository.deleteById(id);
	}

	@Override
	public Optional<Curriculum> buscarCv(Long idCv) {		
		return this.cvRepository.findById(idCv);
	}

	@Override
	public List<Curriculum> getListaDeCv() {		
		return this.cvRepository.findAll();
	}		

}
