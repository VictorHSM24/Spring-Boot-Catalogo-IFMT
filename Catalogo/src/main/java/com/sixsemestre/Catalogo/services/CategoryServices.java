package com.sixsemestre.Catalogo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sixsemestre.Catalogo.dto.CategoryDTO;
import com.sixsemestre.Catalogo.entities.Category;
import com.sixsemestre.Catalogo.repositories.CategoryRepository;
import com.sixsemestre.Catalogo.services.exceptions.DatabaseException;
import com.sixsemestre.Catalogo.services.exceptions.EntityNotFoundException;
import com.sixsemestre.Catalogo.services.exceptions.ResourceNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServices {
	
	private final CategoryRepository repository;
	
	public CategoryServices(CategoryRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream()
				.map(CategoryDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not Found!!"));
		return new CategoryDTO(entity);
	}
	
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
			Category entity = new Category();
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new CategoryDTO(entity);
		}

	@Transactional
	public CategoryDTO update(Long id,CategoryDTO dto) {
		try {
			Category entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new CategoryDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Not Found! " + id );
		}
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found! "+id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
		
	}
	
	@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
		Page<Category> list = repository.findAll(pageRequest);

		return list.map(x -> new CategoryDTO(x));

	}
	
}