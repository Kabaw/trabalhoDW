package backinbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Usuario;

@ManagedBean(name = "usuarioLogadoBean")
@SessionScoped
public class UsuarioLogadoBean {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void init() {
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().
				getFlash().get("usuario");
		if (usuario != null) {
			this.usuario = usuario;
		}

	}
}
