package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import java.util.List;


@Entity
public class Product {
    private int id;
    private String name;
    //Zawiera listę faktur przypisanych do tego produktu
    private List<Item> itemList;


    public Product() {
    }

    public Product(String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToMany(targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItemList() {
        return itemList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
