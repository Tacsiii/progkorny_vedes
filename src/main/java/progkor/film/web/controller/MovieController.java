package progkor.film.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import progkor.film.data.model.Movie;
import progkor.film.service.MovieService;
import java.util.Arrays;
import java.util.List;

/**
 * Controller for handling movie-related HTTP requests.
 */
@Controller
@RequestMapping("/film")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Retrieves a movie by its ID and displays it in an edit form.
     *
     * @param model the model to add attributes to
     * @param id    the ID of the movie to retrieve
     * @return the name of the edit view template
     */
    @GetMapping("/{id}")
    public String getMovieById(Model model, @PathVariable Long id) {
        Movie movie = movieService.retrieveByMovieId(id);
        model.addAttribute("movie", movie);
        model.addAttribute("genres", getGenres());
        return "edit";  // Ensure this matches your edit template name
    }

    /**
     * Retrieves all movies and displays them in a list.
     *
     * @param model the model to add attributes to
     * @return the name of the list view template
     */
    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> allMovies = movieService.retrieveAllMovie();
        model.addAttribute("movies", allMovies);
        return "list";  // Ensure this matches your list template name
    }

    /**
     * Displays a form for creating a new movie.
     *
     * @param model the model to add attributes to
     * @return the name of the create form view template
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", getGenres());
        return "create";  // Ensure this matches your create template name
    }

    /**
     * Creates a new movie.
     *
     * @param movie the movie to create
     * @return a redirect to the list view
     */
    @PostMapping("/create")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.createMovie(movie);
        return "redirect:/film";  // Redirect to avoid form resubmission
    }

    /**
     * Updates an existing movie.
     *
     * @param movie the movie to update
     * @return a redirect to the list view
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateMovie(@ModelAttribute Movie movie) {
        movieService.update(movie);
        return "redirect:/film";  // Redirect to the list view after updating
    }

    /**
     * Deletes a movie by its ID.
     *
     * @param id    the ID of the movie to delete
     * @param model the model to add attributes to
     * @return a redirect to the list view
     */
    @GetMapping("/{id}/delete")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        movieService.deleteMovieById(id);
        return "redirect:/film";  // Redirect to the list view after deleting
    }

    private List<String> getGenres() {
        return Arrays.asList("Action", "Comedy", "Drama", "Horror", "Romance", "Sci-Fi");
    }
}
