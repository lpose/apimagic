package edu.tallerjava.services;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CategoryService{
    public List<Category> getList();

    public Category save(Category category);

    public Optional<Category> findById(Long id);

}
