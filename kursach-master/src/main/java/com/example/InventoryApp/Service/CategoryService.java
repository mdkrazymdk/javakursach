package com.example.InventoryApp.Service;

import com.example.InventoryApp.Model.Category;
import com.example.InventoryApp.Model.CategoryDTO;
import com.example.InventoryApp.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class CategoryService {
   private final CategoryRepository categoryRepository;

   public CategoryService(CategoryRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    public List<Category> findCategoryByName(String name){
       return  categoryRepository.findByCategoryNameContainingIgnoreCase(name);
    }

    public Category save (Category category){
       return categoryRepository.save(category);
    }

    public  List<Category> getAll(){
       return  categoryRepository.findAll();
    }

    public Category createCategory(CategoryDTO categoryDTO){
       var category = new Category(0L,categoryDTO.categoryName());
       return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);}

    public Category updateCategory(Long id, Category updatedResourceData){
       return categoryRepository.findById(id)
               .map(category-> {
                   category.setCategoryName(updatedResourceData.getCategoryName());
                   return categoryRepository.save(category);
               })
               .orElseThrow(() ->new IllegalArgumentException("Resource not found with id: " + id));
    }
}

