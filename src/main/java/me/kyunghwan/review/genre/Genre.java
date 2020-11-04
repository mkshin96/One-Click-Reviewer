package me.kyunghwan.review.genre;

import lombok.*;
import me.kyunghwan.review.moviegenre.MovieGenre;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Genre {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENRE_ID")
    private Long idx;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "genre")
    private final List<MovieGenre> movies = new ArrayList<>();

    public void add(MovieGenre movieGenre) {
        movies.add(movieGenre);
    }

    @Builder
    public Genre(Long idx, String name) {
        this.idx = idx;
        this.name = name;
    }
}
