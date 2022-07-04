package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.entity.Docente;

@Component
public class ListaCurso {
	
	private static ArrayList<Curso> cursos;
	
	Docente docente1 = new Docente(1598,"Ariel","Vega","s@gmail.com");
	Docente docente2 = new Docente(1010,"Gustavo","Sosa","s@gmail.com");
	Docente docente3 = new Docente(2020,"Carolina","Apaza","s@gmail.com");
	Docente docente4 = new Docente(1403,"Juan C","Rodriguez","s@gmail.com");
		
	String detalle1=new String("En curso, aprenderá sobre las declaraciones que controlan el flujo de ejecución de un programa (Estructuras de control). Hay tres categorías de declaraciones de control de programa: declaraciones de selección (Estructuras Condicionales), que incluyen if y switch; declaraciones de iteración (Estructuras de iteración), que incluyen los ciclos o bucles for, while y do-while; y declaraciones de saltojump, que incluyen break, continue y return.");
	String detalle2=new String("El análisis de sistemas permite a los desarrolladores realizar evaluaciones cuantitativas de los sistemas de forma objetiva para seleccionar y/o actualizar la arquitectura del sistema más eficiente y generar datos de ingeniería derivados. Durante la ingeniería, se deben realizar evaluaciones cada vez que se toman decisiones o elecciones técnicas para determinar el cumplimiento de los requisitos del sistema.");
	String detalle3=new String("Quizas una de las partes mas utilizadas y que mas dudas genera en Spring Framework es el framework Spring Security ya que a veces parece que es inmenso y muchas personas no son expertas en seguridad. Te vamos enseñar los conceptos principales que aborda.");
	String detalle4=new String("Un análisis de riesgo-beneficio es una comparación entre los riesgos de una situación y sus beneficios. El objetivo es averiguar si el riesgo o el beneficio es más significativo. Se usa a menudo en medicina, porque cada procedimiento médico tiene riesgos asociados, y algunos procedimientos que podrían ser beneficiosos en realidad resultan estadísticamente más perjudiciales que beneficiosos. Así es como los investigadores médicos determinan si vale la pena realizar ciertos procedimientos y qué tipo de personas se beneficiarán.");
	String detalle5=new String("Aprende Java Intermedio. Usted conocerá las herramientas necesarias de JAVA para la creación de aplicaciones que implementen la programación orientada a objetos.");
	String detalle6=new String("Aprende las características más avanzadas del lenguaje Java e impleméntalas en tus propios proyectos. Aplica conceptos avanzados como Garbage Collection, Multithreading, bases de datos con JDBC y más.");
	String detalle7=new String("Las bases de datos de las grandes empresas de hoy en día soportan a menudo consultas muy complejas y se espera que proporcionen respuestas casi instantáneas a esas consultas. En consecuencia, se solicita a los administradores de bases de datos que empleen una amplia variedad de métodos para ayudar a mejorar el rendimiento.");
	String detalle8=new String("SCSS is a popular preprocessor too for CSS that provides additional highly useful features. The syntax originally was derived from SASS which is a similar tool. In addition to its useful features, SCSS has seen wide adoption because .scss files work with CSS styles too. This course will provide examples for each of the major features in SCSS.");
	String detalle9=new String("SCSS is a popular preprocessor too for CSS that provides additional highly useful features. The syntax originally was derived from SASS which is a similar tool. In addition to its useful features, SCSS has seen wide adoption because .scss files work with CSS styles too. This course will provide examples for each of the major features in SCSS.\"");
	String detalle10=new String("Las habilidades blandas son cada vez más valoradas en nuestra sociedad por su influencia en la probabilidad de adaptabilidad y éxito de las personas en su vida personal, profesional y social. ");
	String detalle11=new String("El análisis del consumidor es el estudio que se realiza sobre el consumidor cuando se elabora una investigación de mercado. Lo más importante es conocer cuáles son sus necesidades y los datos que resulten relevantes. ");
	String detalle12=new String("La Programación Orientada a Objetos es un paradigma de programación que parte del concepto de \"objetos\" como base, los cuales contienen información en forma de campos y código en forma de métodos.");
	String detalle13=new String("Las bases de datos no relacionales son un sistema de almacenamiento de información que se caracteriza por no usar el lenguaje SQL para las consultas. Aprende máscon nosotros");
	String detalle14=new String("Investigar un mercado, ofrecer valor y satisfacer al cliente con un objetivo de lucro. Esta disciplina, también llamada mercadotecnia, se responsabiliza de estudiar el comportamiento de los mercados y de las necesidades de los consumidores.");
	String detalle15=new String("El e-commerce consiste en la distribución, venta, compra, marketing y suministro de información de productos o servicios a través de Internet. ");
	String detalle16=new String("Este curso de publicidad está diseñado para todo tipo de sujeto que esté interesado en aprender a impactar la mente de los consumidores, a través de un diseño y estrategia publicitaria. ");
	String detalle17=new String("Cómo aprender chino por tu cuenta ¡Empieza con un curso en línea fácil y gratuito! Adoptamos un enfoque objetivo y eficiente para aprender a hablar un idioma de forma fácil y rápida: te sugerimos que empieces memorizando palabras, frases y expresiones prácticas que puedas usar en la vida cotidiana y que te sean útiles en tus viajes.");
	String detalle18=new String("La forma más popular para aprender japonés en línea. Aprende japonés en solo 5 minutos diarios con nuestras divertidas lecciones. No importa si estás empezando con lo básico o quieres practicar tu lectura, escritura y conversación; está científicamente comprobado que Duolingo funciona. Lecciones cortas de japonés.");
	String detalle19=new String("Cómo aprender portugués por tu cuenta ¡Empieza con un curso en línea fácil y gratuito! Adoptamos un enfoque objetivo y eficiente para aprender a hablar un idioma de forma fácil y rápida: te sugerimos que empieces memorizando palabras, frases y expresiones prácticas que puedas usar en la vida cotidiana y que te sean útiles en tus viajes.");
	String detalle20=new String("Aprende inglés gratis con nuestros cursos. ¡Mas de 100 lecciones con ejemplos y audio! Distintas y divertidas formas de estudiar inglés: canciones, ejercicios, vídeos, expresiones, chat... Encontrarás además herramientas que te ayudarán a estudiar inglés: conjugador de verbos, traductor, buscador de verbos y phrasal verbs, etc. ¡Pruébalas!");
	
	public ListaCurso() {
		cursos = new ArrayList<>();
		Curso curso1 = new Curso(1,"Java basico","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,10,detalle1) ;
		Curso curso2 = new Curso(2,"Análisis de Sistemas","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,30,detalle2);
		Curso curso3 = new Curso(3,"Spring Security para aprovar el próximo año","Informático",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente2,10,detalle3);
		Curso curso4 = new Curso(4,"Análisis de riesgo veneficio","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente3,15,detalle4);
		Curso curso5 = new Curso(5,"Java intermedio","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20,detalle5);
		Curso curso6 = new Curso(6,"Java avanzado","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20,detalle6);
		Curso curso7 = new Curso(7,"Base de datos","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20,detalle7);
		Curso curso8 = new Curso(8,"Diseño web","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20,detalle8);
		Curso curso9 = new Curso(9,"SCSS","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente2,20,detalle9);
		Curso curso10 = new Curso(10,"Habilidades blandas","RRPP",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Presencial",docente1,20,detalle10);
		Curso curso11 = new Curso(11,"Análisis del consumidor","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,10,detalle11);
		Curso curso12 = new Curso(12,"Prgramacíon Orientada a objetos","Informátio",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),60,"Virtual",docente3,30,detalle12);
		Curso curso13 = new Curso(13,"Base de datos no relacional","Informático",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),30,"Virtual",docente1,10,detalle13);
		Curso curso14 = new Curso(14,"Marketing","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),30,"Presencial",docente1,15,detalle14);
		Curso curso15 = new Curso(15,"E-Comnerce","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),30,"Presencial",docente1,20,detalle15);
		Curso curso16 = new Curso(16,"Publicidad","Comercial",LocalDate.of(2022,7,20),LocalDate.of(2022, 9, 20),40,"Presencial",docente1,20,detalle16);
		Curso curso17 = new Curso(17,"Chino","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Virtual",docente4,10,detalle17);
		Curso curso18 = new Curso(18,"Japonés","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Virtual",docente4,10,detalle18);
		Curso curso19 = new Curso(19,"Portugués","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Virtual",docente4,10,detalle19);
		Curso curso20 = new Curso(20,"Inglés","RRPP",LocalDate.of(2022,7,10),LocalDate.of(2022, 9, 30),80,"Virtual",docente4,10,detalle20);
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
	public static List<Curso> getCursos() {
		return cursos;
	}
	
	public void setUsuarios(ArrayList<Curso> cursos) {
		ListaCurso.cursos = cursos;
	}	
	
}
