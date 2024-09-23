package com.dotpep.productcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotpep.productcrud.ItemRepository;
import com.dotpep.productcrud.model.Item;



@RestController
public class ItemController {
    @Autowired
    ItemRepository repo;

    @GetMapping("/posts")
    public List<Item> getAllItems(){
        return repo.findAll();
    }
}
