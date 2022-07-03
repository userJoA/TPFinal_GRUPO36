package ar.edu.unju.fi.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ILoginCiudadanoService {
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException;
}
