package com.example.Organised;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrgController {

    @Autowired
    RoomRepository repository;

    @GetMapping("/")
    String homePage(Model model) {
        List<Room> rooms = repository.getRooms();

        model.addAttribute("rooms", rooms);


        return "homePage";
    }


}
