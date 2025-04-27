package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;
    @Getter
    private static List<Anime> animes = new ArrayList<>();

    static {
        animes.add(new Anime(1L, "Naruto"));
        animes.add(new Anime(2L, "One Piece"));
        animes.add(new Anime(3L, "Dragon Ball Z"));
    }

}
