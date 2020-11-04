package me.kyunghwan.review.dummy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.kyunghwan.review.movie.Movie;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MovieJson {
    private String code;
    private String name;
    private Integer runningTime;
    private LocalDate openingDate;
    private String imageUrl;
    private final Set<Long> movieGenreIds = new HashSet<>();

    public Movie toEntity() {
        return Movie.builder()
                .code(this.code)
                .name(this.name)
                .runningTime(this.runningTime)
                .openingDate(this.openingDate)
                .imageUrl(this.imageUrl)
                .build();
    }
}
