package com.stefanini.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.treinamento.exceptions.CarroException;
import com.stefanini.treinamento.model.Carro;
import com.stefanini.treinamento.model.Porta;
import com.stefanini.treinamento.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> findAll(){
		return carroRepository.findAll();
	}
	
	public List<Carro> searchByName(String nome){
		return carroRepository.searchByName(nome);
	}
	
	public Carro create(Carro carro) throws CarroException {
		Carro carroEncontrado = carroRepository.buscarPorNomeUnico(carro.getNome());
		
		if(carroEncontrado != null) {
			throw new CarroException("Esse carro já existe ");
		}
		
		Carro carroSalvo = carroRepository.save(carro);
		if(carro.getPortas() != null) {
			carro.getPortas().forEach(porta->{
				porta.setId_carro(carroSalvo.getId_carro());
			});
		}
		
		 carroRepository.save(carro);
		 return carroSalvo;
	}
	
	public Carro update(Carro carro){		
		for(Porta p: carro.getPortas()) {
			if(p.getId_porta() == null) {
				p.setId_carro(carro.getId_carro());
			}
		}
		return carroRepository.save(carro);
	}
	
	public void delete(Long id_carro) {
		carroRepository.deleteById(id_carro);
	}
}
