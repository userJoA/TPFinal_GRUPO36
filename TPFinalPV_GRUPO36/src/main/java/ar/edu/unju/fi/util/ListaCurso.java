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
		Curso curso1 = new Curso(1,"Java basico","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,10);
		Curso curso2 = new Curso(2,"Análisis de Sistemas","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,30);
		Curso curso3 = new Curso(3,"Spring Security para aprovar el próximo año","Informático",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente2,10);
		Curso curso4 = new Curso(4,"Análisis de riesgo veneficio","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente3,15);
		Curso curso5 = new Curso(5,"Java intermedio","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20);
		Curso curso6 = new Curso(6,"Java avanzado","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20);
		Curso curso7 = new Curso(7,"Base de datos","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20);
		Curso curso8 = new Curso(8,"Diseño web","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20);
		Curso curso9 = new Curso(9,"SCSS","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20);
		Curso curso10 = new Curso(10,"Habilidades blandas","RRPP",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente1,20);
		Curso curso11 = new Curso(11,"Análisis del consumidor","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,10);
		Curso curso12 = new Curso(12,"Prgramacíon Orientada a objetos","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,30);
		Curso curso13 = new Curso(13,"Desarrollo","Informático",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),30,"Virtual",docente1,10);
		Curso curso14 = new Curso(14,"Marketing","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),30,"Presencial",docente1,15);
		Curso curso15 = new Curso(15,"E-Comnerce","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),30,"Presencial",docente1,20);
		Curso curso16 = new Curso(16,"Marketing","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),40,"Presencial",docente1,20);
		Curso curso17 = new Curso(17,"Chino","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Presencial",docente4,10);
		Curso curso18 = new Curso(18,"Japonés","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Presencial",docente4,10);
		Curso curso19 = new Curso(19,"Portugués","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Presencial",docente4,10);
		Curso curso20 = new Curso(20,"Inglés","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Presencial",docente4,10);
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);
		cursos.add(curso5);
		cursos.add(curso6);
		cursos.add(curso7);
		cursos.add(curso8);
		cursos.add(curso9);
		cursos.add(curso10);
		cursos.add(curso11);
		cursos.add(curso12);
		cursos.add(curso13);
		cursos.add(curso14);
		cursos.add(curso15);
		cursos.add(curso16);
		cursos.add(curso17);
		cursos.add(curso18);
		cursos.add(curso19);
		cursos.add(curso20);
		
	}
//int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFinal, int cantidadHoras, String modalidad, Docente docente
	public List<Curso> getCursos() {
		return cursos;
	}

}
