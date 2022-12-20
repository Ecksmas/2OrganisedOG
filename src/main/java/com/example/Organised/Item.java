package com.example.Organised;

public class Item {
    private String room;
    private String container;
    private String name;

    public Item(String room, String container, String name) {
        this.room = room;
        this.container = container;
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}