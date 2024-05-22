package progkor.film.data.repository.impl;

import progkor.film.data.model.Movie;
import progkor.film.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the {@link Repository} interface using in-memory storage.
 */
@org.springframework.stereotype.Repository
public class InMemoryMovieRepository implements Repository<Movie, Long> {

    private static final Map<Long, Movie> STORAGE = new HashMap<>();

    /**
     * Saves a movie in the repository.
     *
     * @param movie the movie to save
     * @return the saved movie with an assigned ID
     */
    @Override
    public Movie save(Movie movie) {
        Long id = STORAGE.size() + 1L;
        movie.setId(id);
        STORAGE.put(id, movie);
        return STORAGE.get(id);
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id the ID of the movie to retrieve
     * @return the movie with the specified ID, or null if no movie is found
     */
    @Override
    public Movie getById(Long id) {
        return STORAGE.get(id);
    }

    /**
     * Retrieves all movies in the repository.
     *
     * @return a list of all movies
     */
    @Override
    public List<Movie> getAll() {
        return STORAGE.values().stream().toList();
    }

    /**
     * Updates a movie in the repository.
     *
     * @param movie the movie to update
     * @return the updated movie
     */
    @Override
    public Movie update(Movie movie) {
        Long id = movie.getId();
        STORAGE.put(id, movie);
        return STORAGE.get(id);
    }

    /**
     * Deletes a movie by its ID.
     *
     * @param id the ID of the movie to delete
     */
    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
