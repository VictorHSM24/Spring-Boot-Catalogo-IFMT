package com.sixsemestre.Catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sixsemestre.Catalogo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
