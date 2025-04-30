package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.mapper.AnimeMapper;
import academy.devdojo.request.AnimePostRequest;
import academy.devdojo.response.AnimeGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "v1/animes")
@Slf4j
public class AnimeController {

    private static final AnimeMapper MAPPER = AnimeMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<AnimeGetResponse>> listAll() {
        var animes = Anime.getAnimes();
        var response = MAPPER.toAnimeGetResponseList(animes);
        return ResponseEntity.ok(response);
    }

    @GetMapping("filter")
    public ResponseEntity<List<AnimeGetResponse>> filter(@RequestParam(required = false) String name) {

        var animes = Anime.getAnimes();
        var response = MAPPER.toAnimeGetResponseList(animes);
        if (name == null) return ResponseEntity.ok(response);

        var filteredAnimes = animes.stream()
                .filter(anime -> anime.getName().equalsIgnoreCase(name))
                .toList();
        response = MAPPER.toAnimeGetResponseList(filteredAnimes);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimeGetResponse> findById(@PathVariable Long id) {

        var anime = Anime.getAnimes().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));

        var response = MAPPER.toAnimeGetResponse(anime);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AnimeGetResponse> save(@RequestBody AnimePostRequest request) {
        log.info("Saving {}", request);

        var anime = MAPPER.toAnime(request);
        Anime.getAnimes().add(anime);
        var response = MAPPER.toAnimeGetResponse(anime);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var anime = Anime.getAnimes().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));

        Anime.getAnimes().remove(anime);
        return ResponseEntity.noContent().build();
    }
}
