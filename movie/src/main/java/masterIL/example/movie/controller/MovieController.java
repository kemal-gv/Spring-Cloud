package masterIL.example.movie.controller;

import masterIL.example.movie.dao.MovieRepository;
import masterIL.example.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository dao;
    @Value("${me}")
    private String me;

    @GetMapping(value="/Movies")
    public Iterable<Movie> getMovies() {
        System.out.println("hello");
        return dao.findAll();
    }

    @GetMapping(value="/Movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping(value="Movie")
    public void addMovie(@RequestBody Movie movie) {
        dao.save(movie);
    }

    @DeleteMapping(value="/Movies/{id}")
    public void delete(@PathVariable int id) {
        dao.deleteById(id);
    }

    @PutMapping(value="/Movies/{id}")
    public void update(@RequestBody String movieName, @RequestBody String directorName, @PathVariable int id) {
        dao.findById(id).setName(movieName);
        dao.findById(id).setDirector(directorName);
    }

    @GetMapping(value = "/Cestqui")
    public String getName() {
        return me;
    }
}
