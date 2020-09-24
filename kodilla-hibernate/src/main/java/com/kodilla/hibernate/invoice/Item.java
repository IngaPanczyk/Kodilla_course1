package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;



    public Item() {
    }

    public Item(Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }
@Id
@GeneratedValue
    public int getId() {
        return id;
    }
@ManyToOne
@JoinColumn(name = "PRODUCT")
    public Product getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
