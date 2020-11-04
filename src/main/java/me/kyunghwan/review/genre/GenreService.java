package me.kyunghwan.review.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public Genre findGenreByName(String name) {
        Genre byName = genreRepository.findByName(name);
        return byName;
    }
}
