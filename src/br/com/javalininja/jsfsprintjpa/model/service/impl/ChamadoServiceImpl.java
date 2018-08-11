package br.com.javalininja.jsfsprintjpa.model.service.impl;

import javax.annotation.Resource;

import br.com.javalininja.jsfsprintjpa.model.dao.DaoGenerico;
import br.com.javalininja.jsfsprintjpa.model.entities.Chamado;
import br.com.javalininja.jsfsprintjpa.model.entities.Usuario;
import br.com.javalininja.jsfsprintjpa.model.service.ChamadoService;

public class ChamadoServiceImpl implements ChamadoService {

	@Resource
    private DaoGenerico<Chamado, Integer> chamadoDao;
	
	public DaoGenerico<Chamado, Integer> getChamadoDao() {
		return chamadoDao;
	}

	public void setChamadoDao(DaoGenerico<Chamado, Integer> chamadoDao) {
		this.chamadoDao = chamadoDao;
	}

	@Override
	public Chamado salvar(Chamado chamado) {
		return getChamadoDao().salvar(chamado);
	}

}
