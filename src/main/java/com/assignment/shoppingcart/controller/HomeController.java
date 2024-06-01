package com.assignment.shoppingcart.controller;
import com.assignment.shoppingcart.service.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private HomeServiceImpl homeService;


    @GetMapping("/all")
    public String indexPage(Model model) {
        model.addAttribute("listOfAllStaticProducts", homeService.getAllStaticProducts());
        return "index";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }
}
