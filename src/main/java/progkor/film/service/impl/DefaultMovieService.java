package progkor.film.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progkor.film.data.model.Movie;
import progkor.film.data.repository.Repository;
import progkor.film.service.MovieService;

import java.util.List;

/**
 * Implementation of {@link MovieService} that delegates operations to a {@link Repository}.
 */
@Service
public class DefaultMovieService implements MovieService {

    private final Repository<Movie, Long> movieRepository;

    @Autowired
    public DefaultMovieService(Repository<Movie, Long> movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie retrieveByMovieId(Long id) {
        return movieRepository.getById(id);
    }

    @Override
    public List<Movie> retrieveAllMovie() {
        return movieRepository.getAll();
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.update(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}
