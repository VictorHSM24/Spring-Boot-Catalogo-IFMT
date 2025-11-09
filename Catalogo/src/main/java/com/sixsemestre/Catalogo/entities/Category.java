package com.sixsemestre.Catalogo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Spring vai criar uma tabela em nosso BD
@Table(name = "tb_category") //Spring vai nomear nossa table com o nome especificado 
public class Category implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id // define como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //define com auto incrementável
	private Long id;
	private String name;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	
	public Category() {}

	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	};

}
