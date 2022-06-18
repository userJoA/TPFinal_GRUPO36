package ar.edu.unju.fi.service;



import java.util.List;



import ar.edu.unju.fi.entity.Empleador;


public interface IEmpleadorService {
	
	public Empleador getEmpleador();
	public List<Empleador> listaEmpleador();
	public boolean saveEmpleador(Empleador empleador);
	public void modificarEmpleador(Empleador empleador);
	public void eliminarEmpleador(Long id);
	public Empleador buscarPorId(Long id);
	
	
	
	
}
