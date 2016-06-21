package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mensagem")
public class Mensagem implements Serializable{
	private static final long serialVersionUID = 8637467182782752643L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="idMensagem")
	private Long idMensagem;
	
	@Column(name="conteudo",length=1024,nullable=false)
	private String conteudo;
	
	@Column(name="titulo",length=80,nullable=true)
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario remetente;
	
	@ManyToOne
	@JoinColumn(name="idUsuario", insertable=false,updatable=false)
	private Usuario destinatario;
	
	@Column(name="dataMensagem",nullable=false)
	private Date dataMensagem;
	
	
	public Long getIdMensagem() {
		return idMensagem;
	}
	
	public void setIdMensagem(Long id) {
		this.idMensagem = id;
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
		if (other != null && this.idMensagem !=null){
			return this.idMensagem.equals(other.idMensagem);
		}
		return super.equals(obj);
	}
	
	
	
	
	

}
