package com.example.InventoryApp.Model;

import java.time.LocalDate;

public record ItemDTO(

        Long id,

        String itemName,
        String categoryName,
        int quantity,
        LocalDate expirationDate,
        Long categoryId
) {

}
