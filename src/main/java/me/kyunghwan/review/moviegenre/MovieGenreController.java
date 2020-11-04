package me.kyunghwan.review.moviegenre;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovieGenreController {

    private final MovieGenreService movieGenreService;

    @PostMapping("/moviegenre")
    public ResponseEntity<?> saveMovieGenre(@RequestBody MovieGenre movieGenre) {
        return movieGenreService.saveMovieGenre(movieGenre);
    }
}
