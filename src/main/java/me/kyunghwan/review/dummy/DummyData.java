package me.kyunghwan.review.dummy;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.kyunghwan.review.genre.Genre;
import me.kyunghwan.review.genre.GenreRepository;
import me.kyunghwan.review.movie.Movie;
import me.kyunghwan.review.movie.MovieRepository;
import me.kyunghwan.review.moviegenre.MovieGenre;
import me.kyunghwan.review.moviegenre.MovieGenreRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@RequiredArgsConstructor
@Component
public class DummyData implements ApplicationRunner {

    private final ObjectMapper mapper;

    private final MovieRepository movieRepository;

    private final MovieGenreRepository movieGenreRepository;

    private final GenreRepository genreRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MovieJson[] movieJsons = mapper.readValue(new File("movie.json"), MovieJson[].class);

        String[] names = {"드라마", "판타지", "서부", "공포", "멜로/로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족", "미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스펜스", "서사", "블랙코미디", "실험", "공연실황"};

        for (String name : names) {
            genreRepository.save(Genre.builder()
                    .name(name)
                    .build());
        }

        for (MovieJson movieJson : movieJsons) {
            Movie savedMovie = movieRepository.save(movieJson.toEntity());
            for(Long id : movieJson.getMovieGenreIds()) {
                movieGenreRepository.save(MovieGenre.builder()
                        .genre(genreRepository.findById(id).get())
                        .movie(savedMovie)
                        .build());
            }
        }
    }
}
