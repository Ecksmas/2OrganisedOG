package com.example.Organised;

import java.util.ArrayList;
import java.util.List;

public class Room {
    String room;
    List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }
    public Room(String room) {
        this.room = room;
    }
    public Room() {
    }

    public void addItemToRoom(Item item) {
        items.add(item);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
