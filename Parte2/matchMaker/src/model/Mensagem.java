package model;

import java.io.Serializable;
import java.util.Date;

public class Mensagem implements Serializable{
	private static final long serialVersionUID = 8637467182782752643L;
	private Long id;
	private String conteudo;
	private String titulo;
	private Usuario remetente;
	private Usuario destinatario;
	private Date dataMensagem;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDataMensagem() {
		return dataMensagem;
	}

	public void setDataMensagem(Date dataMensagem) {
		this.dataMensagem = dataMensagem;
	}

	@Override
	public boolean equals(Object obj) {
		Mensagem other = (Mensagem) obj;
		if (other != null && this.id !=null){
			return this.id.equals(other.id);
		}
		return super.equals(obj);
	}
	
	
	
	
	

}
