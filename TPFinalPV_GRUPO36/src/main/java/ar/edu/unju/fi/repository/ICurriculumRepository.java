package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Curriculum;

@Repository
public interface ICurriculumRepository extends JpaRepository<Curriculum,Long>{

}
