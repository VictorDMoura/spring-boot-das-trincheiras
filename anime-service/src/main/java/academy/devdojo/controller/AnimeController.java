package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "v1/animes")
@Slf4j
public class AnimeController {


    @GetMapping
    public List<Anime> listAll() {
        return Anime.getAnimes();
    }

    @GetMapping("filter")
    public List<Anime> filter(@RequestParam(required = false) String name) {

        if (name == null) return Anime.getAnimes();

        return Anime.getAnimes().stream()
                .filter(anime -> anime.getName().equalsIgnoreCase(name))
                .toList();
    }

    @GetMapping("{id}")
    public Anime findById(@PathVariable Long id) {
        return Anime.getAnimes().stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Anime not found"));
    }

    @PostMapping
    public Anime save(@RequestBody Anime anime) {
        log.info("Saving {}", anime);
        var id = ThreadLocalRandom.current().nextLong(1, 1000);
        anime.setId(id);
        Anime.getAnimes().add(anime);
        return anime;
    }
}
