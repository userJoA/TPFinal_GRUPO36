package ar.edu.unju.fi.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Empleador;





@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador,Long>{

	public Optional<Empleador> findByName(Long name);

	

//	public Empleador findByCuit(Long cuit);

//public Optional<Empleador> findByCuit(Long cuit);
}
