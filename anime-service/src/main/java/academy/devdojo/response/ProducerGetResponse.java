package academy.devdojo.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ProducerGetResponse {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
}
