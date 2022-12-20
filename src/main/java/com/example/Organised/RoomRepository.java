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
        vardagsrum.getItemList().add(new Item("Kontroll")); //Upprepa för att lägga in mer
        rooms.add(vardagsrum);

        Room koket = new Room("Köket");
        koket.getItemList().add(new Item("Mjölk 1.5L")); //Upprepa för att lägga in mer
        rooms.add(koket);

        Room badrum = new Room("Badrum");
        badrum.getItemList().add(new Item("Tandborste")); //Upprepa för att lägga in mer
        rooms.add(badrum);

        Room sovrum = new Room("Sovrum");
        sovrum.getItemList().add(new Item("Ipren")); //Upprepa för att lägga in mer
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


}
