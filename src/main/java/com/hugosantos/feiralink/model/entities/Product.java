package com.hugosantos.feiralink.model.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imgUrl, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = new BigDecimal(price.toString());
        this.imgUrl = imgUrl;
        this.category = category;
    }
}
