package backinbean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import model.Usuario;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		usuario.setIdUsuario(null);
		usuario.setDataNascimento(new Date());
		usuario.setEmail("");
		usuario.setLogin("");
		usuario.setSenha("");
		usuario.setNome("");
		usuario.setSexo("");
		usuario.setSobrenome("");

		
	}

	

	public String voltar() {
		return "voltar";
	}

	public String cadastrar() {
		if (usuarioDAO.buscarPorLogin(usuario.getLogin().trim()) != null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "login já cadastrado.", ""));
			return "usuario";
		}
		usuarioDAO.salvar(usuario);
		return "crioulogin";

	}
	
	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user=usuarioDAO.login(usuario);
		if (user == null){
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e/ou Senha incorretos.", ""));
			return "usuario";
		}
		
		context.getExternalContext().getFlash().put("usuario", user);
		return "logou";
	}

}
