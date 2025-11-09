package com.sixsemestre.Catalogo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.sixsemestre.Catalogo.entities.Category;
import com.sixsemestre.Catalogo.entities.Product;

public class ProductDTO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String description;
	private Double price;
	private String imgUrl;
	private Instant date;
	private String name;
	
	private List<CategoryDTO> categories;
	
	public ProductDTO() {
		
	}

	public ProductDTO(Long id, String description, Double price, String imgUrl, Instant date, String name) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.date = date;
		this.name = name;
	}
	
	public ProductDTO(Product entity) {
		super();
		this.id = entity.getId();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
		this.date = entity.getDate();
		this.name = entity.getName();
	}
	
	public ProductDTO(Product entity, Set<Category> categories) {
		this(entity);
		categories.forEach(cat -> this.categories.add(new CategoryDTO()));;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
	
	public String getName() {
	    return name; // Onde 'name' é o campo privado dentro do DTO
	}
	
	

	public List<CategoryDTO> getCategories() {
		return categories;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}
