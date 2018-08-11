package br.com.javalininja.jsfsprintjpa.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_role database table.
 * 
 */
@Entity
@Table(name="usuario_role")
public class UsuarioRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario_Role;

	private String role;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public UsuarioRole() {
	}

	public int getIdUsuario_Role() {
		return this.idUsuario_Role;
	}

	public void setIdUsuario_Role(int idUsuario_Role) {
		this.idUsuario_Role = idUsuario_Role;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}