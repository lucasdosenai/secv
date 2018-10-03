package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import DAO.UsuarioAdmDAO;
import DAO.UsuarioEmpresaDAO;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

@ManagedBean
@ViewScoped
public class tabelaMBean {
	
	public UsuarioEmpresaDAO uDao;
	public UsuarioAdmDAO admDAO;
	UsuarioEmpresa ue;	
	List<UsuarioEmpresa> ues;
	UsuarioEmpresaDAO ueDAO;
	
	
	@ManagedProperty(value = "#{usuarioMBean}")
	private UsuarioMBean userMb;
	private UsuarioEmpresa selectemp;
	
	
	private UsuarioEmpresa emp;
	private UsuarioADM adm;

	
	public tabelaMBean() {

		ue = new UsuarioEmpresa();
		ueDAO = new UsuarioEmpresaDAO();
		ues = ueDAO.listarTodos();
		uDao = new UsuarioEmpresaDAO();
	}
	
	public String alterar() {
		
		emp = userMb.getEmp();
		
		uDao.alterar(emp);
		
		return "perfilEmpresa.xhtml";
		
	}

	
	
	public UsuarioEmpresa getEmp() {
		return emp;
	}

	public void setEmp(UsuarioEmpresa emp) {
		this.emp = emp;
	}

	public void setUserMb(UsuarioMBean userMb) {
		this.userMb = userMb;
	}

	public UsuarioEmpresa getUe() {
		return ue;
	}

	public void setUe(UsuarioEmpresa ue) {
		this.ue = ue;
	}

	public List<UsuarioEmpresa> getUes() {
		return ues;
	}

	public void setUes(List<UsuarioEmpresa> ues) {
		this.ues = ues;
	}

	public UsuarioEmpresaDAO getUeDAO() {
		return ueDAO;
	}

	public void setUeDAO(UsuarioEmpresaDAO ueDAO) {
		this.ueDAO = ueDAO;
	}
	
	

	
}