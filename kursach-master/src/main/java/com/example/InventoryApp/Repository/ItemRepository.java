package com.example.InventoryApp.Repository;

import com.example.InventoryApp.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByItemNameContainingIgnoreCase(String itemName);
}