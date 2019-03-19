package com.stefanini.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.treinamento.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>, CarroRespositoryQuery{

}
