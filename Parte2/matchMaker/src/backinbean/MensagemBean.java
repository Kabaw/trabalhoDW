package backinbean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.MensagemDAO;
import dao.UsuarioDAO;
import model.Mensagem;
import model.Usuario;

@ManagedBean(name = "mensagemBean")
@SessionScoped
public class MensagemBean implements Serializable{
	private static final long serialVersionUID = -1347687441579208409L;
	private Mensagem mensagem;
	private String nomeUsuario;
	private MensagemDAO mensagemDAO = new MensagemDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO(); 
	
	@PostConstruct
	public void init(){
		this.mensagem = new Mensagem();
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().
				getFlash().get("usuario");
		this.mensagem.setRemetente(usuario);
		this.mensagem.setDestinatario(new Usuario());
	}
	
	public void salvar(){
		this.mensagem.setDataMensagem(new Date());
		Usuario usuario = usuarioDAO.buscarPorLogin(nomeUsuario.trim());
		if (usuario!=null){
			mensagem.setDestinatario(usuario);
			mensagemDAO.salvar(mensagem);
		}
		
		
	}
	
	public Mensagem getMensagem() {
		return mensagem;
	}
	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	

}
