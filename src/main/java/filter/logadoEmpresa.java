package filter;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mbean.UsuarioMBean;

@WebFilter("/telas-empresa/*")
public class logadoEmpresa implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		UsuarioMBean umb = (UsuarioMBean) ((HttpServletRequest)request).getSession().getAttribute("usuarioMBean");
		
		if (umb.getEmp() == null) {
			((HttpServletResponse) response).sendRedirect("/secv/login.xhtml");
		}else {
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
	// olha a foto q tem no seu celular!
	
	
}






















