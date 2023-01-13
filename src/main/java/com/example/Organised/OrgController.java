package com.example.Organised;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class OrgController {

    @Autowired
    private OgRoomRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    //Startsida
    @GetMapping("/")
    String homePage(Model model) {
        List<Room> rooms = (List<Room>)repository.findAll(); //Ska testas
        model.addAttribute("rooms", rooms);
        return "newHomePage";
    }

    //Rum-sida
   @GetMapping("/room/{id}")
    String roomPage(Model model, @PathVariable Long id) {
        Room room = repository.findById(id).get();
        model.addAttribute("room", room);
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
            repository.save(room); // todo replace with call POST /book (with book object as json in request body)
        return "redirect:/";
    }

    //Lägga till item till rum
    @GetMapping("/addItem")
    public String addItem(Model model){
        model.addAttribute("item", new Item());
        return "newRoom";
    }

    @PostMapping("/saveItem")
    public String setItem (@ModelAttribute Item item, @RequestParam Long id) {
        Room roomId = repository.findById(id).get();
        item.setRoom(roomId);
        itemRepository.save(item);
        return "newRoom";
    }

  /*  //Spara item till ett rum
    @PostMapping("/saveItem")
    public String setItem(Model model, @RequestParam String room, @RequestParam String item) { //Tagit bort String room från param och Long id i slutet.
      Room roomId = repository.findById(id).get();

      itemRepository.save(itemName);
      //Item item1 = new Item();
      //roomId.addItemToRoom(new Item()); //Tagit bort namn "item" pga ändring i constructorn.
      model.addAttribute("room", roomId);
      return "redirect:/newRoom";
    }*/

/*
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
    */
}
