package me.kyunghwan.review.moviegenre;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MovieGenreService {

    private final MovieGenreRepository movieGenreRepository;

    @Transactional
    public ResponseEntity<?> saveMovieGenre(MovieGenre movieGenre) {
        System.out.println("===========save query===========");
        MovieGenre save = movieGenreRepository.save(movieGenre);

        System.out.println("===========find real real movie query===========");
        save.getMovie().add(save);

        System.out.println("===========find genre query===========");
        save.getGenre().add(save);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
