package model;

import java.io.Serializable;
import java.util.List;

public class Grupo implements Serializable{
	private static final long serialVersionUID = -3243567335862690405L;
	private Long id;
	private String nome;
	private List<Usuario> usuarios;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object obj) {
		Grupo other = (Grupo) obj;
		if (other != null && this.id !=null){
			return this.id.equals(other.id);
		}
		return super.equals(obj);
	}
	
}
