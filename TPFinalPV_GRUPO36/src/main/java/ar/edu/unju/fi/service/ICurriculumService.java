package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Curriculum;

public interface ICurriculumService {
	
	public Curriculum getCv();
	public boolean guardarCv(Curriculum cv);
	public void modificarCv(Curriculum cv);
	public void eliminarCv(Long id);
	public Optional<Curriculum> buscarCv(Long idCv);
	public List<Curriculum> getListaDeCv();
	
}
