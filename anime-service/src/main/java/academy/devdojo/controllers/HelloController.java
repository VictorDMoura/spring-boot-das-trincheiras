package academy.devdojo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "greetings")
public class HelloController {

    @GetMapping("hi")
    public String hi() {
        return "OMAE WA MOU SHINDEIRU";
    }
}
