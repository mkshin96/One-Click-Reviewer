package me.kyunghwan.review.moviegenre;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
