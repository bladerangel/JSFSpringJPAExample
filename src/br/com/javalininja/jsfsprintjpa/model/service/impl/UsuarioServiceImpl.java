package br.com.javalininja.jsfsprintjpa.model.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import br.com.javalininja.jsfsprintjpa.model.service.UsuarioService;
import br.com.javalininja.jsfsprintjpa.model.dao.DaoGenerico;
import br.com.javalininja.jsfsprintjpa.model.entities.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

	@Resource
    private DaoGenerico<Usuario, Integer> usuarioDao;

	public DaoGenerico<Usuario, Integer> getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(DaoGenerico<Usuario, Integer> usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public Usuario buscaPorLoginESenha(String login, String senha) {
		Usuario usuario = null;
        String query = "SELECT u FROM Usuario u WHERE u.dataDelecao is null AND u.login=:login and u.senha=:senha";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", login);
        params.put("senha", senha);
        usuario = getUsuarioDao().pesqParam(query , params);
        return usuario;
	}

	@Override
	public Usuario buscaPorEmail(String email) {
		Usuario usuario = null;
        String query = "SELECT u FROM Usuario u WHERE u.dataDelecao is null AND u.email=:email";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        usuario = getUsuarioDao().pesqParam(query , params);
        return usuario;
	}

	@Override
	public Usuario atualizaUsuario(Usuario usuario) {
		return getUsuarioDao().atualizar(usuario);
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		return getUsuarioDao().salvar(usuario);
	}
}
