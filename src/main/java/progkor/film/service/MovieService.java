package progkor.film.service;

import progkor.film.data.model.Movie;

import java.util.List;

public interface MovieService {

    /*
     * TODO.
     *@param movies TODO.
     *@return TODO.
     * */
    Movie createMovie(Movie movie);

    Movie retrieveByMovieId(Long id);
    List<Movie> retrieveAllMovie();

    Movie update(Movie movie);

    void deleteMovieById(Long id);
}
