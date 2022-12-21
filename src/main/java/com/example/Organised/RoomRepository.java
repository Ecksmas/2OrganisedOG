package com.example.Organised;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {
    private List<Room> rooms;

    public RoomRepository() {
        rooms = new ArrayList<>();
        Room vardagsrum = new Room("Vardagsrum");
        vardagsrum.addItemToRoom(new Item("Kontroll")); //Upprepa för att lägga in mer
        vardagsrum.addItemToRoom(new Item("Kuddar"));
        vardagsrum.addItemToRoom(new Item("Soffa"));
        vardagsrum.addItemToRoom(new Item("Stolar"));
        vardagsrum.addItemToRoom(new Item("Bord"));
        rooms.add(vardagsrum);

        Room koket = new Room("Köket");
        koket.addItemToRoom(new Item("Mjölk 1.5L")); //Upprepa för att lägga in mer
        koket.addItemToRoom(new Item("Bröd"));
        koket.addItemToRoom(new Item("Knäckebröd"));
        koket.addItemToRoom(new Item("Vispgrädde"));
        rooms.add(koket);

        Room badrum = new Room("Badrum");
        badrum.addItemToRoom(new Item("Tandborste")); //Upprepa för att lägga in mer
        badrum.addItemToRoom(new Item("Toalettpapper"));
        badrum.addItemToRoom(new Item("Tandkräm"));
        badrum.addItemToRoom(new Item("Shampoo"));
        rooms.add(badrum);

        Room sovrum = new Room("Sovrum");
        sovrum.addItemToRoom(new Item("Ipren")); //Upprepa för att lägga in mer
        sovrum.addItemToRoom(new Item("Bibel"));
        rooms.add(sovrum);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(String roomPick) {
        for (Room room : rooms) {
            if (room.getRoom().equals(roomPick)) {
                return room;
            }
        }
        return null;
    }

    public void addItem(String item) {
        Room room = new Room();
        room.addItemToRoom(new Item(item));

    }

    public Room addRoom(Room room) {
        if (rooms.size() < 10) {
            rooms.add(room);
        }
        return room;
    }

   public void deleteRoom(Room room) {
        rooms.remove(room);
    }

}
