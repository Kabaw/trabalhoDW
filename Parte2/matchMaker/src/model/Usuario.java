package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Usuario implements Serializable{
	private static final long serialVersionUID = -4610897792604370929L;
	private Long id;
	private String login;
	private String senha;
	private String nome;
	private String sobrenome;
	private String email;
	private String sexo;
	private Date dataNascimento;
	private List<Mensagem> mensagensEnviadas;
	private List<Mensagem> mensagensRecebidas;
	private List<Usuario> amigos;
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
	public List<Usuario> getAmigos() {
		return amigos;
	}
	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	@Override
	public boolean equals(Object obj) {
		Usuario other = (Usuario) obj;
		if (other != null && this.id !=null){
			return this.id.equals(other.id);
		}
		return super.equals(obj);
	}
	
	
}
