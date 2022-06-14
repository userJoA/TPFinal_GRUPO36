package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;

@Service
public interface ICiudadanoRepository extends JpaRepository<Ciudadano,Long>{

}
