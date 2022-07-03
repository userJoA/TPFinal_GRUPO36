package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.entity.Docente;


public class ListaCurso {
	private List<Curso> cursos;
	
	Docente docente1 = new Docente(1598,"Ariel","Vega","s@gmail.com");
	Docente docente2 = new Docente(1010,"Gustavo","Sosa","s@gmail.com");
	Docente docente3 = new Docente(2020,"Carolina","Apaza","s@gmail.com");
	Docente docente4 = new Docente(1403,"Juan C","Rodriguez","s@gmail.com");
		
	
	public ListaCurso() {
		cursos = new ArrayList<>();
		Curso curso1 = new Curso(1,"Idiomas","RRPP",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3);
		Curso curso2 = new Curso(2,"Diseño","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente4);
		Curso curso3 = new Curso(3,"Desarrollo","Informático",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente1);
		Curso curso4 = new Curso(4,"Marketing","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente1);
		Curso curso5 = new Curso(5,"Conferencias","RRPP",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2);
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);
		cursos.add(curso5);
	}
//int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFinal, int cantidadHoras, String modalidad, Docente docente
	public List<Curso> getCursos() {
		return cursos;
	}

}
