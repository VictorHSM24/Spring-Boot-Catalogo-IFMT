package com.sixsemestre.Catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sixsemestre.Catalogo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}