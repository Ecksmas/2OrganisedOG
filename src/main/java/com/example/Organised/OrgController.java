package com.example.Organised;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrgController {

    @Autowired
    ItemRepository repository;

    @GetMapping("/")
    String homePage(Model model) {
        List<Item> items = repository.getItems();

        model.addAttribute("items", items);


        return "homePage";
    }


}
