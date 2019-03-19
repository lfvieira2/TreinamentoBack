package com.stefanini.treinamento.repository;

import java.util.List;

import com.stefanini.treinamento.model.Carro;

public interface CarroRespositoryQuery {

	public List<Carro> searchByName(String nome);
	
	public Carro buscarPorNomeUnico(String nome);
	
}
