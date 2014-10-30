package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.Formats;
import play.db.ebean.Model;
@Entity
public class Evento extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String descricao;
	private String observacao;
	private String local;
	@Formats.DateTime(pattern="dd/MM/yyyy HH")
	private Date data;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public static Model.Finder<Long, Evento> find = new Model.Finder<Long,Evento>(Long.class, Evento.class);

}
