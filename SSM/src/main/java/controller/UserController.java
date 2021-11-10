package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

@RequestMapping("/mvc")
    public String save(){
        System.out.println("Controller save running");
        return "/index.jsp";
    }
}
