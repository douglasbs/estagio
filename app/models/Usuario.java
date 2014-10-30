package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class Usuario extends Model {
	private static final long serialVersionUID = -8950828806553001326L;

	@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Required
	@Column(nullable = false)
	private String username;
	@Required
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = true)
	private String nome;
	
	public Usuario() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public static Model.Finder<Integer,Usuario> find =
			new Model.Finder<Integer,Usuario>(Integer.class,Usuario.class);
	
}
