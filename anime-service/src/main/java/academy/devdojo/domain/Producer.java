package academy.devdojo.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producer {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private LocalDateTime createdAt;

    @Getter
    private static List<Producer> producers = new ArrayList<>();

    static {
        var mappa = Producer.builder()
                .id(1L)
                .name("Mappa")
                .createdAt(LocalDateTime.now())
                .build();
        var kyotoAnimation = Producer.builder()
                .id(2L)
                .name("Kyoto Animation")
                .createdAt(LocalDateTime.now())
                .build();
        var madHouse = Producer.builder()
                .id(3L)
                .name("Mad House")
                .createdAt(LocalDateTime.now())
                .build();
        producers.addAll(List.of(mappa, kyotoAnimation, madHouse));
    }


}
