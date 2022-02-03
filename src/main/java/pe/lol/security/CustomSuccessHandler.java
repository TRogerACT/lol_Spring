package pe.lol.security;

import java.io.IOException;
import java.util.ArrayList;
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
public class CustomSuccessHandler implements AuthenticationSuccessHandler
{
	//objeto de redireccionamiento
	private RedirectStrategy redirect=new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException 
	{
		String URL=determineTargetUrl(authentication);
		
		//redireccionamiento
		redirect.sendRedirect(request,response,URL);
	}
	
	public String determineTargetUrl(Authentication authentication)
	{
		String url=null;
		
		//colección vacío
		Collection<String> roles=new ArrayList<>();
		
		//recorrer todos los permisos del authentication
		for(GrantedAuthority authority:authentication.getAuthorities()) 
		{
			String rol=authority.getAuthority();
			roles.add(rol);
		}
		
		if(roles.contains("ROLE_DBA")) {
			url="/index";
		} else if(roles.contains("ROLE_ADMIN")) {
			url="/index";
		} else if(roles.contains("ROLE_USER")) {
			url="/usuario";
		} else {
			url="/access_denied";
		}			
		
		return url;
	}
}





























