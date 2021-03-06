package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public final class Invoice {
    private int id;
    private String number;
    List<Item> items;

    public Invoice() {
    }

    public Invoice(String number) {
        this.id = id;
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Id
    @GeneratedValue
    @NotNull
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    @OneToMany(targetEntity = Item.class,
            mappedBy = "invoice",
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }
}
