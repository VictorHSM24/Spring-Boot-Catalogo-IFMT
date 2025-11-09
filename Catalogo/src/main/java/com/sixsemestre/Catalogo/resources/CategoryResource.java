package com.sixsemestre.Catalogo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sixsemestre.Catalogo.dto.CategoryDTO;
import com.sixsemestre.Catalogo.entities.Category;
import com.sixsemestre.Catalogo.services.CategoryServices;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	private final CategoryServices service;
	
	public CategoryResource(CategoryServices service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy
			
		){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		
		Page<CategoryDTO> list = service.findAllPaged(pageRequest);
		return  ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}") 
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
	
	@PostMapping
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
			dto = service.insert(dto);
			//http 201 location header
			String uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toString();
			return ResponseEntity.ok().body(dto);
		}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> insert(@PathVariable Long id, @RequestBody CategoryDTO dto){
		dto = service.update(id, dto);
		return  ResponseEntity.ok().body(dto);
	}
	
}
