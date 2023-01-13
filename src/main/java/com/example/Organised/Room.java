package com.example.Organised;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String roomName;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

  //  private List<Item> items = new ArrayList<>();

    //TOM CONSTRUCTOR
    public Room() {
    }


    //CONSTRUCTOR
    public Room(Long id, String roomName) {
        this.id = id;
        this.roomName = roomName;
    }


    //GETTERS OCH SETTERS
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    //FUNCTIONER

    /*    //SAVE
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

    public List<Item> getItems() {
        return items;
    }

    //DELETE
    public void deleteItem(Item item) {
        items.remove(item);
    }*/

}
