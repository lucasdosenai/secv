package mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioDAO;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

@ManagedBean
@SessionScoped
public class UsuarioMBean {

	UsuarioDAO uDao;
	String imagem;

	String empreOUadm;
	String senha;

	public UsuarioMBean() {
		imagem = "on";
		uDao = new UsuarioDAO();
	}

	public void trocaImagem() {
		imagem = imagem.equals("on") ? "off" : "on";
		System.out.println("Caiu");
	}

	private String loginEmpresa() {
		UsuarioEmpresa emp = uDao.buscarEmpresa(Integer.valueOf(empreOUadm), senha);
		if ( emp != null) {
			return "temfiltro.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usu�rio e/ou  Senha invalido(s)"));
		return "login.xhtml";
	}

	private String loginADM() {
		UsuarioADM adm = uDao.buscarADM(Integer.valueOf(empreOUadm), senha);
		if (adm != null) {
			return "homeADM.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usu�rio e/ou  Senha invalido(s)"));
		return "login.xhtml";
	}
	
	public String logar() {
		if(imagem.equals("on")) {
			return loginADM();
		}else if(imagem.equals("off")) {
			return loginEmpresa();
		}else {
			return null;
		}
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getEmpreOUadm() {
		return empreOUadm;
	}

	public void setEmpreOUadm(String empreOUadm) {
		this.empreOUadm = empreOUadm;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	value="#{UsuarioMBean.uEmpresa.CNPJ}"

//	action="#{usuarioMBean.doEfetuarLogin}"
}
