package br.com.javalininja.jsfsprintjpa.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private short ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_delecao")
	private Date dataDelecao;

	private String email;

	private String foto;

	private String login;

	private String nome;

	private String senha;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="usuario")
	private List<Chamado> chamados;

	//bi-directional many-to-many association to Projeto
	@ManyToMany
	@JoinTable(
		name="usuario_has_projeto"
		, joinColumns={
			@JoinColumn(name="Usuario_idUsuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Projeto_idProjeto")
			}
		)
	private List<Projeto> projetos;

	//bi-directional many-to-many association to Tarefa
	@ManyToMany
	@JoinTable(
		name="usuario_has_tarefa"
		, joinColumns={
			@JoinColumn(name="Usuario_idUsuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Tarefa_idTarefa")
			}
		)
	private List<Tarefa> tarefas;

	//bi-directional many-to-one association to UsuarioRole
	@OneToMany(mappedBy="usuario")
	private List<UsuarioRole> usuarioRoles;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public short getAtivo() {
		return this.ativo;
	}

	public void setAtivo(short ativo) {
		this.ativo = ativo;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataDelecao() {
		return this.dataDelecao;
	}

	public void setDataDelecao(Date dataDelecao) {
		this.dataDelecao = dataDelecao;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Chamado addChamado(Chamado chamado) {
		getChamados().add(chamado);
		chamado.setUsuario(this);

		return chamado;
	}

	public Chamado removeChamado(Chamado chamado) {
		getChamados().remove(chamado);
		chamado.setUsuario(null);

		return chamado;
	}

	public List<Projeto> getProjetos() {
		return this.projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<UsuarioRole> getUsuarioRoles() {
		return this.usuarioRoles;
	}

	public void setUsuarioRoles(List<UsuarioRole> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	public UsuarioRole addUsuarioRole(UsuarioRole usuarioRole) {
		getUsuarioRoles().add(usuarioRole);
		usuarioRole.setUsuario(this);

		return usuarioRole;
	}

	public UsuarioRole removeUsuarioRole(UsuarioRole usuarioRole) {
		getUsuarioRoles().remove(usuarioRole);
		usuarioRole.setUsuario(null);

		return usuarioRole;
	}

}