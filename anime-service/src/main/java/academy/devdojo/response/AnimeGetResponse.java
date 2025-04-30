package academy.devdojo.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnimeGetResponse {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
}
