package com.example.Organised;

import jakarta.persistence.*;

@Entity
@Table(name="ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String itemName;
    @ManyToOne ()
    private Room room;

    //TOM CONSTRUCTOR
    public Item() {
    }

    //CONSTRUCTOR
    public Item(Long id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    //SETTERS OCH GETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}