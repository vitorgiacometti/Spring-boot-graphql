package br.example.graphql.invoice.domain;

import br.example.graphql.product.domain.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String customer;
    private Long price;
    private Long tax;

    @ManyToMany
    @JoinColumn(name = "Id", updatable = false)
    private List<Product> products;

    public Invoice() {
    }

    public Invoice(String customer, Long price, Long tax) {
        this.customer = customer;
        this.price = price;
        this.tax = tax;
    }

    public Invoice(String customer, Long price, Long tax, List<Product> products) {
        this.customer = customer;
        this.price = price;
        this.tax = tax;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
}
