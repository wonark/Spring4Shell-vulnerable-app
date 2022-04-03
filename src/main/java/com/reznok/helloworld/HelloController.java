package com.reznok.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @GetMapping("/greeting")
    public String greetingGet(@ModelAttribute Greeting greeting, Model model) {        
        return "hello";
    }

    @PostMapping("/greeting")
    public String greetingPost(@ModelAttribute Greeting greeting, Model model) {
        return "hello";
    }

}
