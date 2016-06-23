package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{
	private static final long serialVersionUID = -3243567335862690405L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="idGrupo")
	private Long idGrupo;
	
	@Column(name="nome", length=20, nullable=false)
	private String nome;
	
	
	@ManyToMany (mappedBy="grupos", cascade = {CascadeType.ALL})
	private List<Usuario> usuarios;
	
	
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long id) {
		this.idGrupo = id;
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
		if (other != null && this.idGrupo !=null){
			return this.idGrupo.equals(other.idGrupo);
		}
		return super.equals(obj);
	}
	
}
