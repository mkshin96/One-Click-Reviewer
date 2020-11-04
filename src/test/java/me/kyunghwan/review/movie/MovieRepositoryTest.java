package me.kyunghwan.review.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kyunghwan.review.BaseControllerTest;
import me.kyunghwan.review.genre.Genre;
import me.kyunghwan.review.genre.GenreService;
import me.kyunghwan.review.moviegenre.MovieGenre;
import me.kyunghwan.review.moviegenre.MovieGenreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MovieRepositoryTest extends BaseControllerTest {

    @Autowired
    private GenreService genreService;

    @Autowired
    private MovieGenreService movieGenreService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @DisplayName("Movie를 저장하는 테스트")
    @Test
    void movieTest() {
        String code = "45290";
        String name = "인터스텔라";
        int runningTime = 169;
        LocalDate localDate = LocalDate.of(2014, 11, 6);
        String imageUrl = "imageUrl";

        Movie movie = movieRepository.save(Movie.builder()
                .code(code)
                .name(name)
                .runningTime(runningTime)
                .openingDate(localDate)
                .imageUrl(imageUrl)
                .build());

        String[] arr = {"SF", "판타지"};

        for (String str : arr) {

            Movie movie1 = movieRepository.findById(1L).orElseGet(() -> movie);
            Genre genre = genreService.findGenreByName(str);

            MovieGenre mg = MovieGenre.builder()
                    .movie(movie1)
                    .genre(genre)
                    .build();

            movieGenreService.saveMovieGenre(mg);
        }

        assertThat(movieGenreRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    void saveTest() throws Exception {
        String code = "45290";
        String name = "인터스텔라";
        int runningTime = 169;
        LocalDate localDate = LocalDate.of(2014, 11, 6);
        String imageUrl = "imageUrl";

        Movie movie = movieRepository.save(Movie.builder()
                .code(code)
                .name(name)
                .runningTime(runningTime)
                .openingDate(localDate)
                .imageUrl(imageUrl)
                .build());

        String[] arr = {"SF", "판타지"};
        for (String str : arr) {
            Movie movie1 = movieRepository.findById(1L).orElseGet(() -> movie);
            Genre genre = genreService.findGenreByName(str);

            MovieGenre mg = MovieGenre.builder()
                    .movie(movie1)
                    .genre(genre)
                    .build();

            mockMvc.perform(post("/moviegenre")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsBytes(mg)))
                    .andDo(print())
                    .andExpect(status().isCreated());

        }


    }
}
