package academy.devdojo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Anime {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private LocalDateTime createdAt;

    @Getter
    private static List<Anime> animes = new ArrayList<>();

    static {
        var naruto = Anime.builder()
                .id(1L)
                .name("Naruto")
                .createdAt(LocalDateTime.now())
                .build();
        var onePiece = Anime.builder()
                .id(2L)
                .name("One Piece")
                .createdAt(LocalDateTime.now())
                .build();
        var dragonBallZ = Anime.builder()
                .id(3L)
                .name("Dragon Ball Z")
                .createdAt(LocalDateTime.now())
                .build();
        animes.addAll(List.of(naruto, onePiece, dragonBallZ));
    }

}
