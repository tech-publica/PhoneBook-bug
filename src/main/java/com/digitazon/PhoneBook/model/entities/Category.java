package com.digitazon.PhoneBook.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
    @SequenceGenerator(name = "category_generator", sequenceName = "categories_id_seq",
            allocationSize = 1)
    private int id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "color")
    private String color;

    public Category() {
    }

    public Category(int id) {
        this.id = id;
    }

    public Category(int id, String groupName, String color) {
        this.id = id;
        this.groupName = groupName;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
