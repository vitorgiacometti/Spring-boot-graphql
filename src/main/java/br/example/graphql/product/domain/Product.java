package br.example.graphql.product.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String description;
    private Long value;

    public Product() { }

    public Product(String name, String description, Long value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public Product(Long id) {
        Id = id;
    }

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

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

    public Long getValue() {  return value;  }

    public void setValue(Long value) { this.value = value; }
}
