package br.com.javalininja.jsfsprintjpa.model.service;

import br.com.javalininja.jsfsprintjpa.model.entities.Usuario;

public interface UsuarioService {

	public Usuario buscaPorLoginESenha(String login, String senha);
	public Usuario buscaPorEmail(String email);
	public Usuario atualizaUsuario(Usuario usuario);
	public Usuario salvar(Usuario usuario);
}
