package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jogo")
public class Jogo implements Serializable{

	private static final long serialVersionUID = -3119678998469247487L;
	
	@ManyToMany (mappedBy="jogos")
	private List<Usuario> usuarios;
	
	@Column(name="nome", length=20, nullable=false)
	private String nome;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="idJogo")
	private Long idJogo;
	
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
	public Long getIdJogo() {
		return idJogo;
	}
	public void setIdJogo(Long id) {
		this.idJogo = id;
	}
	@Override
	public boolean equals(Object obj) {
		Jogo other = (Jogo) obj;
		if (other != null && this.idJogo !=null){
			return this.idJogo.equals(other.idJogo);
		}
		return super.equals(obj);
	}
	

}
