package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.OfertaLaboral;



@Service
public interface IOfertaLaboralRepository extends JpaRepository<OfertaLaboral,Long> {
	
}
