package com.stefanini.treinamento.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stefanini.treinamento.model.Carro;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarroRepositoryTest {

	@Autowired
	private CarroRepository repo;
	
	
	// Teste unitário pelo nome do carro cadastrado no banco h2
	@Test
	public void testaCarroNome() {
		List<Carro> carros = repo.searchByName("UP");
		assertThat(carros.size()).isEqualTo(1); 
	}
}
