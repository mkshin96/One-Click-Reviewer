package me.kyunghwan.review.moviegenre;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kyunghwan.review.genre.Genre;
import me.kyunghwan.review.movie.Movie;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class MovieGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.EAGER)
    private Genre genre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    @Builder
    public MovieGenre(Long idx, Genre genre, Movie movie) {
        this.idx = idx;
        this.genre = genre;
        this.movie = movie;
    }

}
