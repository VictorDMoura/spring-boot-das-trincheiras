package academy.devdojo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "v1/greeting")
@Slf4j
public class HelloController {

    @GetMapping("hi")
    public String hi() {
        return "OMAE WA MOU SHINDEIRU";
    }

    @PostMapping
    public Long save(@RequestBody String name) {
        log.info("Saving {}", name);
        return ThreadLocalRandom.current().nextLong(1, 1000);
    }

}
