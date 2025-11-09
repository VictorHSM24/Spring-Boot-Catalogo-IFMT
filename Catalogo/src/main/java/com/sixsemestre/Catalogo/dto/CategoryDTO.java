package com.sixsemestre.Catalogo.dto;

import com.sixsemestre.Catalogo.entities.Category;

public class CategoryDTO {

	private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    // Construtor padrão (necessário para o Spring/Jackson)
    public CategoryDTO() {
    }

    // Construtor com todos os argumentos
    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Construtor que recebe a entidade Category
    // Usado para converter a Entidade em DTO
    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    // Getters e Setters
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
	
}
