package ar.edu.unju.fi;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticacionSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		boolean tipoAdmin = false;
		boolean tipoEmpleador = false;
		boolean tipoCiudadano = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("tipoAdmin")) {
				tipoAdmin = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("tipoEmpleador")) {
					tipoEmpleador = true;
					break;
			} else {
				tipoCiudadano = true;
				break;
			}
		}
		}
		if (tipoAdmin) {
			redirectStrategy.sendRedirect(request, response, "/");
		} else {
			if (tipoEmpleador) {
				redirectStrategy.sendRedirect(request, response, "/empleador/inicio");
		} else {
			if (tipoCiudadano) {
				redirectStrategy.sendRedirect(request, response, "/ciudadano/inicio");
			} else {
				throw new IllegalStateException();	
			}
		}			
		}
	}

}
