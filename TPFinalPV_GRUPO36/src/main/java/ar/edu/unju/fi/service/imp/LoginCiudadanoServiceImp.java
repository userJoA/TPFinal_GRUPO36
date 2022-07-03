package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import ar.edu.unju.fi.entity.Usuario;

import ar.edu.unju.fi.repository.IUsuarioRepository;
@Service
public class LoginCiudadanoServiceImp implements UserDetailsService{
@Autowired
private IUsuarioRepository iUsuario;


	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
			Usuario ciudadanoEncontrado = iUsuario.findByDni(Long.parseLong(dni)).orElseThrow(()-> new UsernameNotFoundException("Login invalido"));
			
			List<GrantedAuthority> tipos = new ArrayList<>();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ciudadanoEncontrado.getTipo()); 
			tipos.add(grantedAuthority);
			
			UserDetails user =( UserDetails) new User (dni, ciudadanoEncontrado.getPassword(),tipos);
			
			return user;
		
		
	}

}
