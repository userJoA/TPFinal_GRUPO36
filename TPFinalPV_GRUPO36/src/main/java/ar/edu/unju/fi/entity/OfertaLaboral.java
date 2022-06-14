package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Ofertas_laborales")
public class OfertaLaboral {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //clave primaria.
	@Column(name = "id_oferta_laboral")	
	private Long customerNumber;
	
	private int cantidad_vacantes;
	private String puesto; 
	private String resumen;
	private int disponibilidad_horaria;
	private String tareas;
	private String datos;
	private int jornada;
	private String sequisitos;
	private int salario;
	private String beneficios;
	private boolean disponible=true;
	
	
	public OfertaLaboral() {
		super();
	}


	public Long getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}


	public int getCantidad_vacantes() {
		return cantidad_vacantes;
	}


	public void setCantidad_vacantes(int cantidad_vacantes) {
		this.cantidad_vacantes = cantidad_vacantes;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	public String getResumen() {
		return resumen;
	}


	public void setResumen(String resumen) {
		this.resumen = resumen;
	}


	public int getDisponibilidad_horaria() {
		return disponibilidad_horaria;
	}


	public void setDisponibilidad_horaria(int disponibilidad_horaria) {
		this.disponibilidad_horaria = disponibilidad_horaria;
	}


	public String getTareas() {
		return tareas;
	}


	public void setTareas(String tareas) {
		this.tareas = tareas;
	}


	public String getDatos() {
		return datos;
	}


	public void setDatos(String datos) {
		this.datos = datos;
	}


	public int getJornada() {
		return jornada;
	}


	public void setJornada(int jornada) {
		this.jornada = jornada;
	}


	public String getSequisitos() {
		return sequisitos;
	}


	public void setSequisitos(String sequisitos) {
		this.sequisitos = sequisitos;
	}


	public int getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}


	public String getBeneficios() {
		return beneficios;
	}


	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		return "OfertasLaborales [customerNumber=" + customerNumber + ", cantidad_vacantes=" + cantidad_vacantes
				+ ", puesto=" + puesto + ", resumen=" + resumen + ", disponibilidad_horaria=" + disponibilidad_horaria
				+ ", tareas=" + tareas + ", datos=" + datos + ", jornada=" + jornada + ", sequisitos=" + sequisitos
				+ ", salario=" + salario + ", beneficios=" + beneficios + ", disponible=" + disponible + "]";
	}
	
	
	
	
	
	
}
