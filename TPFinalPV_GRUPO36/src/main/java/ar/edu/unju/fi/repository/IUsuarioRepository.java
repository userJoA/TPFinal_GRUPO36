package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Usuario;



public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

}
