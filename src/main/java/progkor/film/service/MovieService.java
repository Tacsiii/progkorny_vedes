package progkor.film.service;

import progkor.film.data.model.Movie;

import java.util.List;

/**
 * TODO: Add Javadoc comment.
 */
public interface MovieService {

    /**
     * Creates a new movie.
     *
     * @param movie the movie to create
     * @return the created movie
     */
    Movie createMovie(Movie movie);

    /**
     * Retrieves a movie by its ID.
     *
     * @param id the ID of the movie to retrieve
     * @return the movie with the specified ID
     */
    Movie retrieveByMovieId(Long id);

    /**
     * Retrieves all movies.
     *
     * @return a list of all movies
     */
    List<Movie> retrieveAllMovie();

    /**
     * Updates a movie.
     *
     * @param movie the movie to update
     * @return the updated movie
     */
    Movie update(Movie movie);

    /**
     * Deletes a movie by its ID.
     *
     * @param id the ID of the movie to delete
     */
    void deleteMovieById(Long id);
}
