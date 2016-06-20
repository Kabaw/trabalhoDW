package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = -4610897792604370929L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="idUsuario")
	private Long idUsuario;
	
	@Column(name="login", length=40, nullable=false, unique=true)
	private String login;
	
	@Column(name="senha", length=40, nullable=false)
	private String senha;
	
	@Column(name="nome", length=20, nullable=false)
	private String nome;
	
	@Column(name="sobrenome", length=20, nullable=false)
	private String sobrenome;
	
	@Column(name="email", length=20, nullable=false)
	private String email;
	
	@Column(name="sexo", length=1, nullable=false)
	private String sexo;
	
	@Column(name="dataNascimento", nullable=false)
	private Date dataNascimento;
	
	@OneToMany(mappedBy="remente")
	private List<Mensagem> mensagensEnviadas;
	
	@OneToMany(mappedBy="destinatario")
	private List<Mensagem> mensagensRecebidas;
	
	@ManyToMany
	@JoinTable(name="usuariogrupo", joinColumns  = {@JoinColumn(name="idUsuario",nullable=false,updatable=false)},
			inverseJoinColumns={@JoinColumn(name="idGrupo",nullable=false,updatable=false)})
	private List<Grupo> grupos;
	
	@ManyToMany
	@JoinTable(name="usuariojogo", joinColumns  = {@JoinColumn(name="idUsuario",nullable=false,updatable=false)},
			inverseJoinColumns={@JoinColumn(name="idJogo",nullable=false,updatable=false)})
	private List<Jogo> jogos;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Mensagem> getMensagensEnviadas() {
		return mensagensEnviadas;
	}
	public void setMensagensEnviadas(List<Mensagem> mensagensEnviadas) {
		this.mensagensEnviadas = mensagensEnviadas;
	}
	public List<Mensagem> getMensagensRecebidas() {
		return mensagensRecebidas;
	}
	public void setMensagensRecebidas(List<Mensagem> mensagensRecebidas) {
		this.mensagensRecebidas = mensagensRecebidas;
	}
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	@Override
	public boolean equals(Object obj) {
		Usuario other = (Usuario) obj;
		if (other != null && this.idUsuario !=null){
			return this.idUsuario.equals(other.idUsuario);
		}
		return super.equals(obj);
	}
	
	
}
