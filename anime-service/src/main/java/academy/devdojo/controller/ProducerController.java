package academy.devdojo.controller;

import academy.devdojo.domain.Producer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "v1/producers")
public class ProducerController {

    @GetMapping
    public List<Producer> listAll() {
        return Producer.getProducers();
    }

    @GetMapping("filter")
    public List<Producer> filter(@RequestParam(required = false) String name) {
        if (name == null) return Producer.getProducers();

        return Producer.getProducers().stream()
                .filter(producer -> producer.getName().equalsIgnoreCase(name))
                .toList();
    }

    @GetMapping("{id}")
    public Producer findById(@PathVariable Long id) {
        return Producer.getProducers().stream()
                .filter(producer -> producer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producer not found"));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "x-api-key")
    public Producer save(@RequestBody Producer producer) {
        var id = ThreadLocalRandom.current().nextLong(1, 1000);
        producer.setId(id);
        Producer.getProducers().add(producer);
        return producer;
    }
}
