package masterIL.example.movie.dao;

import masterIL.example.movie.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    //Iterable<Movie> findByDirector(String director);
    Movie findById(int id);
    void deleteById(int id);
    Iterable<Movie> findAll();
    //void update(Movie movie, int id);
}
