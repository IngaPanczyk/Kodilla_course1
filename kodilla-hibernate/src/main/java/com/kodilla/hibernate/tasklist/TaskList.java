package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
//@Table(name = "TASKLIST")
public final class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList() {
    }

    public TaskList( String listName, String description) {
        this.id = id;
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    //@Column(name = "ID_TASKLIST")
    public int getId() {
        return id;
    }

    public String getListName() {
        return listName;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}