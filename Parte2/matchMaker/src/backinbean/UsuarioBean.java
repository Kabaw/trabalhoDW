package backinbean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.UsuarioJDBC;
import model.Usuario;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private UsuarioJDBC usuarioJDBC = new UsuarioJDBC();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String novo() {
		usuario.setId(null);
		usuario.setDataNascimento(new Date());
		usuario.setEmail("");
		usuario.setLogin("");
		usuario.setSenha("");
		usuario.setNome("");
		usuario.setSexo("");
		usuario.setSobrenome("");

		return "usuario";

	}

	public String voltar() {
		return "voltar";
	}

	public String cadastrar() {

		usuarioJDBC.salvar(usuario);
		return "crioulogin";

	}

}
