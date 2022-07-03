package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class EstadoCivil {
	
	private ArrayList<String> estadoC = new ArrayList<String>();
	
	public EstadoCivil() {
		estadoC.add("Casado");
		estadoC.add("Soltero");
		estadoC.add("Viudo");
		estadoC.add("Divorciado");
		estadoC.add("Otro");
		
	}

	public ArrayList<String> getEstadoC() {
		return estadoC;
	}

	public void setEstadoC(ArrayList<String> estadoC) {
		this.estadoC = estadoC;
	}
	
	
}
