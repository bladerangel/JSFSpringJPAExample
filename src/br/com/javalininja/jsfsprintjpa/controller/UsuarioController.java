package br.com.javalininja.jsfsprintjpa.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.javalininja.jsfsprintjpa.model.entities.Usuario;
import br.com.javalininja.jsfsprintjpa.model.entities.UsuarioRole;
import br.com.javalininja.jsfsprintjpa.model.service.UsuarioRoleService;
import br.com.javalininja.jsfsprintjpa.model.service.UsuarioService;
import br.com.javalininja.jsfsprintjpa.util.Md5Util;

@Controller(value="usuarioController")
@Scope("request")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRoleService usuarioRoleService;
	
	private Usuario usuario = new Usuario();
	
	private String senha2;
	
	private String msg;
	
	public String saveAction() {
		
		String sMd5 = null;
		try {
			sMd5 = Md5Util.hashMd5(getSenha2());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		usuario.setSenha(sMd5);
		usuario.setDataCriacao(new Date());
		short ativo = 1;
		usuario.setAtivo(ativo);
		Usuario u = usuarioService.salvar(usuario);
		UsuarioRole role = new UsuarioRole();
		role.setRole("ROLE_USER");
		role.setUsuario(u);
		return "";
	}
	

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getSenha2() {
		return senha2;
	}


	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public UsuarioRoleService getUsuarioRoleService() {
		return usuarioRoleService;
	}


	public void setUsuarioRoleService(UsuarioRoleService usuarioRoleService) {
		this.usuarioRoleService = usuarioRoleService;
	}
	
	
}
