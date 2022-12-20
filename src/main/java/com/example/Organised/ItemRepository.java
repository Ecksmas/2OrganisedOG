package com.example.Organised;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        items.add(new Item("Vardagsrum", "Tv-bänk", "Kontrollen"));
        items.add(new Item("Kök", "Kylskåp", "Mjölk 1.5L"));
        items.add(new Item("Badrum", "Spegelskåp", "Tandborste"));
        items.add(new Item("Sovrum", "Sängbord", "Ipren"));
    }

    public List<Item> getItems() {
        return items;
    }
}
