package com.stefanini.treinamento.negocios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.stefanini.treinamento.model.Carro;
import com.stefanini.treinamento.model.Porta;
import com.stefanini.treinamento.repository.CarroRespositoryQuery;

@Repository
public class CarroRepositoryImpl implements CarroRespositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Carro> searchByName(String nome) {
		List<Carro> carroEncontrados = null;
		
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
			Root<Carro>root = criteriaQuery.from(Carro.class);

			//Join<Carro, Porta>portas = root.join("portas",JoinType.INNER);
			Predicate[] predicates = criarRestricao(nome,builder,root);
			criteriaQuery.where(predicates);
			
			TypedQuery<Carro>typedQuery = manager.createQuery(criteriaQuery);
			carroEncontrados = typedQuery.getResultList();
			
			return carroEncontrados;
		} catch (Exception e) {
			return carroEncontrados;
		}
	}

	private Predicate[] criarRestricao(String nome, CriteriaBuilder builder, Root<Carro> root) {
		List<Predicate> predicates  = new ArrayList<>();
		if(!StringUtils.isEmpty(nome)) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + (nome.toLowerCase()) + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	@Override
	public Carro buscarPorNomeUnico(String nome) {
		Carro carroEncontrados = null;
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
			Root<Carro>root = criteriaQuery.from(Carro.class);
			Predicate[] predicates = criarRestricaoNome(nome,builder,root);
			criteriaQuery.where(predicates);
			
			TypedQuery<Carro>typedQuery = manager.createQuery(criteriaQuery);
			carroEncontrados = typedQuery.getSingleResult();
			
			return carroEncontrados;
		} catch (Exception e) {
			return carroEncontrados;
		}
		
	}

	private Predicate[] criarRestricaoNome(String nome, CriteriaBuilder builder, Root<Carro> root) {
		List<Predicate> predicates  = new ArrayList<>();
		if(!StringUtils.isEmpty(nome)) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + (nome.toLowerCase()) + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}
