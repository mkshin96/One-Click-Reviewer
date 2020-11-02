package me.kyunghwan.review.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kyunghwan.review.moviegenre.MovieGenre;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long id;

    private String code;


    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> genres;
}
