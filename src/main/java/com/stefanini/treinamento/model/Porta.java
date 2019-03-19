package com.stefanini.treinamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "porta")
public class Porta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_id_porta", sequenceName = "SQ_id_porta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_id_porta")
	@Column(name = "id_porta", length = 5)
	private Long id_porta;

	@Column(name = "descricao", length = 20)
	private String descricao;
	
	@Column(name = "id_carro")
	private Long id_carro;
	
	public Long getId_porta() {
		return id_porta;
	}
	
	public void setId_porta(Long id_porta) {
		this.id_porta = id_porta;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getId_carro() {
		return id_carro;
	}
	
	public void setId_carro(Long id_carro) {
		this.id_carro = id_carro;
	}
	
	public Porta(Long id_porta, String descricao, Long id_carro) {
		super();
		this.id_porta = id_porta;
		this.descricao = descricao;
		this.id_carro = id_carro;
	}
	
	public Porta() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_porta == null) ? 0 : id_porta.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Porta other = (Porta) obj;
		if (id_porta == null) {
			if (other.id_porta != null)
				return false;
		} else if (!id_porta.equals(other.id_porta))
			return false;
		return true;
	}
}
