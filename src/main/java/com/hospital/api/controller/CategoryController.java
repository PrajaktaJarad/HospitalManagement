package com.hospital.api.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.api.model.Category;
import com.hospital.api.repository.CategoryRepository;

@RestController
 @CrossOrigin(origins = {"http://localhost:4200/"})
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/hospital/category")
	public List<Category> getAllCategories() {
		return categoryRepository.findAll().stream()
					.sorted(Comparator.comparing(Category :: getSequence))
					.collect(Collectors.toList());
	}
	
	@PostMapping("/hospital/category")
	public Category postCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

}
