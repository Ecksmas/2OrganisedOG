package com.example.Organised;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   @GetMapping("/room/{id}")
    String roomPage(Model model, @PathVariable Long id) {
        Room room = repository.findById(id).get();
        model.addAttribute("room", room);
        return "newRoom";
    }

    @GetMapping("/add")
    String addRoom(Model model) {
        model.addAttribute("room", new Room());
        return "form";
    }

    @PostMapping("/save")
    public String saveRoom(@ModelAttribute Room room) {
        repository.save(room);
        return "redirect:/";
    }

    @GetMapping("/addItem")
    public String add(Model model, @PathVariable Long id){
        Room roomId = repository.findById(id).get(); //Hitta id:t på rummet
        Item item1 = new Item(); //Skapa ett nytt objekt
        item1.setRoom(roomId); // set Room idet på objektet, för att länka ihop.
        model.addAttribute("room", roomId); //Skicka till thymeleaf
        model.addAttribute("item", item1);//Skicka till thymeleaf
        return "newRoom";
    }

    @PostMapping("/saveItem")
    public String saveItem (@ModelAttribute Item item){
        itemRepository.save(item); //Sparar objektet
        return "redirect:/room/" + item.getRoom().getId(); //Skickar tillbaka till /room/{id}
    }

    @GetMapping("editRoom")
    public String editRoom (Model model, @PathVariable Long id){

    }



    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Long id){
        Item item = itemRepository.findById(id).get();//Hämtar id till rummet där item finns.
        itemRepository.deleteById(id);//Raderar Item.
        return "redirect:/room/" + item.getRoom().getId(); //Kommer tillbaka till rummet igen.
    }

}
