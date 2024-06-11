package com.example.InventoryApp.Repository;

import com.example.InventoryApp.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByCategoryNameContainingIgnoreCase(String categoryName);
}
