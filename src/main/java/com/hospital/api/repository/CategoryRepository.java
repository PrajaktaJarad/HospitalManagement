package com.hospital.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
