package com.example.InventoryApp.Service;

import com.example.InventoryApp.Model.Item;
import com.example.InventoryApp.Model.ItemDTO;
import com.example.InventoryApp.Model.Category;
import com.example.InventoryApp.Repository.ItemRepository;
import com.example.InventoryApp.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Item> findByItemName(String itemName) {
        return itemRepository.findByItemNameContainingIgnoreCase(itemName);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item createItem(ItemDTO itemDTO) {
        var item = new Item(0L, itemDTO.itemName(), itemDTO.categoryName(), itemDTO.quantity(), itemDTO.expirationDate(),itemDTO.categoryId());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item updateItem(Long id, Item updatedItemData) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setItemName(updatedItemData.getItemName());
                    item.setCategoryName(updatedItemData.getCategoryName());
                    item.setQuantity(updatedItemData.getQuantity());
                    item.setExpirationDate(updatedItemData.getExpirationDate());
                    item.setCategoryId(updatedItemData.getCategoryId());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id: " + id));
    }
}
