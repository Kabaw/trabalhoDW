package backinbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import model.Mensagem;
import model.Usuario;

public class MensagemBean implements Serializable{
	private static final long serialVersionUID = -1347687441579208409L;
	private Mensagem mensagem;
	
	@PostConstruct
	public void init(){
		this.mensagem = new Mensagem();
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().
				getFlash().get("usuario");
		this.mensagem.setRemetente(usuario);
		this.mensagem.setDestinatario(new Usuario());
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
	
	

}
