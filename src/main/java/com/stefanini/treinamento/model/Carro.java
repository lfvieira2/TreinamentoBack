package com.stefanini.treinamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="carro")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SQ_id_carro", sequenceName = "SQ_id_carro", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SQ_id_carro")
	@Column(name="id_carro")
	private Long id_carro;
	
	
	@Column(name="nome", length=20)
	private String nome;
   
	@Size(min=1, max=5)
	@OneToMany(mappedBy = "id_carro",fetch = FetchType.LAZY,
	cascade= {CascadeType.ALL},orphanRemoval=true)
	private List<Porta> portas;

	public Long getId_carro() {
		return id_carro;
	}

	public void setId_carro(Long id_carro) {
		this.id_carro = id_carro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Porta> getPortas() {
		return portas;
	}

	public void setPortas(List<Porta> portas) {
		this.portas = portas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_carro == null) ? 0 : id_carro.hashCode());
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
		Carro other = (Carro) obj;
		if (id_carro == null) {
			if (other.id_carro != null)
				return false;
		} else if (!id_carro.equals(other.id_carro))
			return false;
		return true;
	}

	public Carro(Long id_carro, @NotNull String nome, @Size(min = 1, max = 5) List<Porta> portas) {
		super();
		this.id_carro = id_carro;
		this.nome = nome;
		this.portas = portas;
	}

	public Carro() {
		super();
	}
}
