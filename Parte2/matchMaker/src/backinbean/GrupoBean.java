package backinbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import dao.UsuarioDAO;
import model.Usuario;

@ManagedBean(name = "grupoBean")
@SessionScoped
public class GrupoBean {
	private DualListModel<Usuario> usuarios;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public DualListModel<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(DualListModel<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void init() {
		List<Usuario> usuariosDB = usuarioDAO.listar();
		List<Usuario> selecionados = new ArrayList<Usuario>();
		usuarios = new DualListModel<Usuario>(usuariosDB, selecionados);
		
	}
	
}
