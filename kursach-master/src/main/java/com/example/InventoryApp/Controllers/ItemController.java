package com.example.InventoryApp.Controllers;

import com.example.InventoryApp.Model.Item;
import com.example.InventoryApp.Model.ItemDTO;
import com.example.InventoryApp.Service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){this.itemService = itemService;}

    @GetMapping
    public List<Item> getAll(){return itemService.getAll();}

    @PostMapping
    public Item createItem(@RequestBody ItemDTO item){return  itemService.createItem(item);}

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item){
        Item updatedItem = itemService.updateItem(id,item);
        if(updatedItem != null)
        {return  ResponseEntity.ok(updatedItem);}
        else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id)
    {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}