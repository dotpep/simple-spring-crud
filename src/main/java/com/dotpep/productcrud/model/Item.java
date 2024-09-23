package com.dotpep.productcrud.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProductItem")
public class Item {
    private String name;
    private String description;
    //private flaot price;
    //private Date createdAt;

    public Item() {
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Item [name=" + name + ", description=" + description + "]";
    }
    
}
