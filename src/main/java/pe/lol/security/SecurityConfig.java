package pe.lol.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private CustomSuccessHandler customSuccessHandler;
	
	@Override //método de autenticación
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		//usuarios en memoria
		auth.inMemoryAuthentication().withUser("wendy").password("$2a$10$x35O45FxMFl1X6Wl95cmReacg89zxPK04xC2ccskdpR56hHNcRNV2").roles("USER");
		auth.inMemoryAuthentication().withUser("diego").password("$2a$10$8IGSRQF6h0IAFiWJ.cQ5JOaV5W04d6XjOrHIHN0mI8Al3EpCqXI3.").roles("USER");
		auth.inMemoryAuthentication().withUser("Jiro").password("$2a$10$Pp5n5ts05AjYthXvg4UFZOSR3DNVwOp4R5Mn3YmMFC6aUtVCWLEBW").roles("USER");
		auth.inMemoryAuthentication().withUser("rafael").password("$2a$10$PXZa9Xba1AdEPXe57HaF0uuep0r4Rvys8gM8eFyQnOh9TObiTWCz.").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("RogerAC").password("$2a$10$E/p/jI2I8IThF2Lrn.mfauq.geRkYqhmeV5mLJPl13vBucmP2FGZS").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("fabrizio").password("$2a$10$noUlsRPDneCgvhHfbEVkz.kiuYhfTO4A..5uISHIuNJ4M7dr8lpFu").roles("ADMIN","DBA");		
	}
	
	@Override //método de autorización
	protected void configure(HttpSecurity http) throws Exception 
	{
		//permisos
		http.authorizeRequests()
		    .antMatchers("/","/index1").permitAll()
		    .antMatchers("/user/**").access("hasRole('USER')")
		    .antMatchers("/admin/**").access("hasRole('ADMIN')")
		    .antMatchers("/dba/**").access("hasRole('ADMIN') and hasRole('DBA')");
		
		//excepciones
		http.authorizeRequests().and()
		    .exceptionHandling().accessDeniedPage("/access_denied");
		
		//seguridad de agentes extraños (opcional, por defecto ya viene habilitado)
		http.authorizeRequests().and()
		    .csrf();
		
		//login personalizado
		http.authorizeRequests().and()
		    .formLogin()
		    .loginPage("/login")
		    .usernameParameter("txtUsername")
		    .passwordParameter("txtPassword")
		    .successHandler(customSuccessHandler);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}














