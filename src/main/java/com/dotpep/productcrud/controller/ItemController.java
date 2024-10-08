package com.dotpep.productcrud.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dotpep.productcrud.ItemRepository;
import com.dotpep.productcrud.exception.ResourceNotFoundException;
import com.dotpep.productcrud.model.Item;

import jakarta.validation.Valid;



@RestController
public class ItemController {
    @Autowired
    ItemRepository repo;

    @GetMapping("/item/list")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = repo.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getOneItem(
        @PathVariable(value = "id") String itemId) throws ResourceNotFoundException {
        Item item = repo.findById(itemId).orElseThrow(
            () -> new ResourceNotFoundException("Item not found with id : " + itemId));
        
        return ResponseEntity.ok(item);
    }

    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        System.out.println("Saving Item: " + item);

        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        Item newItem = repo.save(item);

        return ResponseEntity.ok(newItem);
    }

    @PatchMapping("/item/{id}")
    public ResponseEntity<Item> partiallyUpdateItem(
        @PathVariable(value = "id") String itemId,
        @Valid @RequestBody Item itemDetails) throws ResourceNotFoundException {

        System.out.println("Updating Item: " + itemId);

        Item item = repo.findById(itemId).orElseThrow(
            () -> new ResourceNotFoundException( "Item not found on: " + itemId));

        if (itemDetails.getName() != null) {
            item.setName(itemDetails.getName());
        }
        if (itemDetails.getDescription() != null) {
            item.setDescription(itemDetails.getDescription());
        }
        if (
            itemDetails.getPrice() != null && 
            itemDetails.getPrice().compareTo(BigDecimal.ZERO) >= 0
        ) {
            item.setPrice(itemDetails.getPrice());
        }

        item.setUpdatedAt(LocalDateTime.now());

        final Item updatedItem = repo.save(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable(value = "id") String itemId) throws ResourceNotFoundException {
        repo.findById(itemId).orElseThrow(
            () -> new ResourceNotFoundException("Item not found with id : " + itemId));

        repo.deleteById(itemId);

        return ResponseEntity.ok("Item was deleted successfully!");
    }
}
