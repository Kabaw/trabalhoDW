package model;

import java.io.Serializable;
import java.util.List;

public class Jogo implements Serializable{

	private static final long serialVersionUID = -3119678998469247487L;
	private List<Usuario> usuarios;
	private String nome;
	private Long id;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		Jogo other = (Jogo) obj;
		if (other != null && this.id !=null){
			return this.id.equals(other.id);
		}
		return super.equals(obj);
	}
	

}
