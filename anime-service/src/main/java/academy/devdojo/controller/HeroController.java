package academy.devdojo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/heroes")
public class HeroController {

    public static final List<String> HEROES = List.of("Superman", "Batman", "Zoro", "Luffy", "Goku");

    @GetMapping
    public List<String> listAll() {
        return HEROES;
    }

    @GetMapping("filter")
    public List<String> filter(@RequestParam(required = false, defaultValue = "Goku") String name) {
        return HEROES.stream()
                .filter(hero -> hero.equalsIgnoreCase(name))
                .toList();
    }

    @GetMapping("filterList")
    public List<String> filterList(@RequestParam List<String> names) {
        return HEROES.stream()
                .filter(names::contains)
                .toList();
    }

    @GetMapping("{name}")
    public String findByName(@PathVariable String name) {
        return HEROES.stream()
                .filter(hero -> hero.equalsIgnoreCase(name))
                .findAny().orElse("");
    }
}
