package com.example.Organised;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String room;
    List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }


    public Room(Long id, String room) {
        this.id = id;
        this.room = room;
    }
    public Room() {

    }
    //SAVE
    public Item addItemToRoom(Item item) {
       items.add(item);
        return item;
    }

    //FINDBYID
    public Item getItem(String itemPick) {
        for (Item item : items) {
            if (item.getName().equals(itemPick)) {
                return item;
            }
        }
        return null;
    }

    //DELETE
    public void deleteItem(Item item) {
        items.remove(item);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
