package backinbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import dao.GrupoDAO;
import dao.UsuarioDAO;
import model.Grupo;
import model.Usuario;

@ManagedBean(name = "grupoBean")
@SessionScoped
public class GrupoBean implements Serializable {
	private static final long serialVersionUID = -6507209973009058659L;
	private Grupo grupo;
	private DualListModel<Usuario> usuarios;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private GrupoDAO grupoDAO = new GrupoDAO();
	private String titulo;

	@PostConstruct
	public void init() {
		grupo = new Grupo();
		List<Usuario> usuariosDB = usuarioDAO.listar();

		List<Usuario> selecionados = new ArrayList<Usuario>();
		usuarios = new DualListModel<Usuario>(usuariosDB, selecionados);
		titulo = "Novo Grupo";
	}

	public String salvar() {
		grupo.setUsuarios(usuarios.getTarget());
		grupoDAO.salvar(grupo);
		return "";
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public DualListModel<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(DualListModel<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String voltar() {

		return "voltar";
	}

}
