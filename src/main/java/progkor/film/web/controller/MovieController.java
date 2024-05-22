package progkor.film.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import progkor.film.data.model.Movie;
import progkor.film.service.MovieService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/film")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String getMovieById(Model model, @PathVariable Long id) {
        Movie movie = movieService.retrieveByMovieId(id);
        model.addAttribute("movie", movie);
        model.addAttribute("genres", getGenres());
        return "edit";  // Ensure this matches your edit template name
    }

    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> allMovies = movieService.retrieveAllMovie();
        model.addAttribute("movies", allMovies);
        return "list";  // Ensure this matches your list template name
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", getGenres());
        return "create";  // Ensure this matches your create template name
    }

    @PostMapping("/create")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.createMovie(movie);
        return "redirect:/film";  // Redirect to avoid form resubmission
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateMovie(@ModelAttribute Movie movie) {
        movieService.update(movie);
        return "redirect:/film";  // Redirect to the list view after updating
    }

    @GetMapping("/{id}/delete")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        movieService.deleteMovieById(id);
        return "redirect:/film";  // Redirect to the list view after deleting
    }

    private List<String> getGenres() {
        return Arrays.asList("Action", "Comedy", "Drama", "Horror", "Romance", "Sci-Fi", "Thriller");
    }
}
