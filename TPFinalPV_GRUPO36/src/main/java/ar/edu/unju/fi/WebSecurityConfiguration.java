package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ar.edu.unju.fi.service.imp.LoginCiudadanoServiceImp;


@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration {
	@Autowired
	private AuthenticacionSuccessHandler autenticacion;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/webjars/**" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers(resources).permitAll().antMatchers("/", "/home","/curso/**","/alta/ciudadano","/ciudadano/formulario","/empleador/guardar","/alta/empleador").permitAll().antMatchers(resources).permitAll().anyRequest()

				.authenticated().and().formLogin().loginPage("/login").permitAll().successHandler(autenticacion)
				.failureUrl("/login?error=true").usernameParameter("dni").passwordParameter("password").and().logout()
				.permitAll();

		http.headers().frameOptions().sameOrigin();

		return http.build();
	}

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}

	@Autowired
	LoginCiudadanoServiceImp userDetailsService;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
