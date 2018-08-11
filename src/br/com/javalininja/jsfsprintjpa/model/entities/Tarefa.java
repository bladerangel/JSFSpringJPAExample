package br.com.javalininja.jsfsprintjpa.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tarefa database table.
 * 
 */
@Entity
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTarefa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fim")
	private Date dataFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inicio")
	private Date dataInicio;

	private String descricao;

	private int numero;

	private String titulo;

	//bi-directional many-to-many association to Chamado
	@ManyToMany
	@JoinTable(
		name="chamado_has_tarefa"
		, joinColumns={
			@JoinColumn(name="Tarefa_idTarefa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Chamado_idChamado")
			}
		)
	private List<Chamado> chamados;

	//bi-directional many-to-one association to Projeto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProjeto")
	private Projeto projeto;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="tarefas")
	private List<Usuario> usuarios;

	public Tarefa() {
	}

	public int getIdTarefa() {
		return this.idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}