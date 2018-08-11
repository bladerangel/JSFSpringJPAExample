package br.com.javalininja.jsfsprintjpa.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projeto database table.
 * 
 */
@Entity
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fim")
	private Date dataFim;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="projeto")
	private List<Chamado> chamados;

	//bi-directional many-to-one association to Tarefa
	@OneToMany(mappedBy="projeto")
	private List<Tarefa> tarefas;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="projetos")
	private List<Usuario> usuarios;

	public Projeto() {
	}

	public int getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
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

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Chamado addChamado(Chamado chamado) {
		getChamados().add(chamado);
		chamado.setProjeto(this);

		return chamado;
	}

	public Chamado removeChamado(Chamado chamado) {
		getChamados().remove(chamado);
		chamado.setProjeto(null);

		return chamado;
	}

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Tarefa addTarefa(Tarefa tarefa) {
		getTarefas().add(tarefa);
		tarefa.setProjeto(this);

		return tarefa;
	}

	public Tarefa removeTarefa(Tarefa tarefa) {
		getTarefas().remove(tarefa);
		tarefa.setProjeto(null);

		return tarefa;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}