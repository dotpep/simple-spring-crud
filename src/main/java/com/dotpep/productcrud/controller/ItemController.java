package com.dotpep.productcrud.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dotpep.productcrud.ItemRepository;
import com.dotpep.productcrud.model.Item;



@RestController
public class ItemController {
    @Autowired
    ItemRepository repo;

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return repo.findAll();
    }

    @PostMapping("/item")
    public Item createItem(@RequestBody Item item){
        System.out.println("Saving Item: " + item);

        item.setCreatedAt(LocalDateTime.now());
        return repo.save(item);
    }
}
