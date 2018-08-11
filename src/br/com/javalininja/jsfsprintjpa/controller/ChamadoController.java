package br.com.javalininja.jsfsprintjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.javalininja.jsfsprintjpa.model.entities.Chamado;
import br.com.javalininja.jsfsprintjpa.model.service.ChamadoService;

@Controller(value="chamadoController")
@Scope("request")
public class ChamadoController {
	
	private Chamado chamado;

	@Autowired
	private ChamadoService chamadoService;
	
	public String satlvarChamado() {
		return "";
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public ChamadoService getChamadoService() {
		return chamadoService;
	}

	public void setChamadoService(ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
	}
}
