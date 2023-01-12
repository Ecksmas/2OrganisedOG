package com.example.Organised;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrgController {

    @Autowired
    RoomRepository repository;

    //Startsida
    @GetMapping("/")
    String homePage(Model model) {
        List<Room> rooms = repository.getRooms();
        model.addAttribute("rooms", rooms);
        return "newHomePage";
    }

    //Rum-sida
    @GetMapping("/room/{room}")
    String roomPage(Model model, @PathVariable String room) {
        Room roomPick = repository.getRoom(room);
        model.addAttribute("room", roomPick);


        return "newRoom";
    }

    //Lägga till ett nytt rum på startsidan.
    @GetMapping("/add")
    String add(Model model) {
        model.addAttribute("room", new Room());
        return "form";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Room room) {
            repository.addRoom(room); // todo replace with call POST /book (with book object as json in request body)
        return "redirect:/";
    }



    //Lägga till item i resp rum.
    @PostMapping("/addItem")
    public String setItem(Model model, @RequestParam String room, @RequestParam String item) {
      Room roomItem = repository.getRoom(room);
      roomItem.addItemToRoom(new Item(item));
      model.addAttribute("room", roomItem);
      return "newRoom";
    }


    //Ta bort rum
    @GetMapping("/delete")
    public String deleteRoom(@RequestParam String room) {
        Room delete = repository.getRoom(room);
        repository.deleteRoom(delete);
        return "redirect:/";
    }

    //Ta bort items i resp rum.
    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam String room, @RequestParam String item) {
        Room roomToDeleteFrom = repository.getRoom(room);
        Item itemToDelete = roomToDeleteFrom.getItem(item);
        roomToDeleteFrom.deleteItem(itemToDelete);
        return "redirect:/room/" + roomToDeleteFrom.getRoom();

    }
}
