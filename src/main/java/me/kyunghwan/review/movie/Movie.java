package me.kyunghwan.review.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kyunghwan.review.moviegenre.MovieGenre;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long idx;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    @Column
    private Integer runningTime;

    @Column
    private LocalDate openingDate;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "movie")
    private final List<MovieGenre> movieGenres = new ArrayList<>();

    public void add(MovieGenre movieGenre) {
        this.movieGenres.add(movieGenre);
    }

    @Builder
    public Movie(Long idx, String code, String name, Integer runningTime, LocalDate openingDate, String imageUrl) {
        this.idx = idx;
        this.code = code;
        this.name = name;
        this.runningTime = runningTime;
        this.openingDate = openingDate;
        this.imageUrl = imageUrl;
    }
}
