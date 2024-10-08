package com.dotpep.productcrud.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProductItem")
public class Item {
    @Id  // mongodb generated id field
    private String id;

    private String name;
    private String description;
    private BigDecimal price;

    private String title;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Item() {
        //this.createdAt = LocalDateTime.now();
        //this.updatedAt = LocalDateTime.now();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", title="
                + title + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }
}
