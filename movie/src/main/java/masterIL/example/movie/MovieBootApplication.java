package masterIL.example.movie;

import jakarta.annotation.PostConstruct;
import masterIL.example.movie.dao.MovieRepository;
import masterIL.example.movie.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.util.Arrays;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieBootApplication {
    private static final Logger log = LoggerFactory.getLogger(MovieBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MovieBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MovieRepository movieRepository){
        return (args -> {
            movieRepository.save(new Movie(1, "Interstellar", "Christopher Nolan"));
            movieRepository.save(new Movie(2, "Minority Report", "Steven Spielberg"));

            log.info("Affichage de tous les films ---(findAll)---");
            for (Movie movie : movieRepository.findAll()){
                log.info(movie.toString());
            }

            log.info("Affichage d'1 seul film ---(findById(2))---");
            Movie m = movieRepository.findById(2);
            log.info(m.toString());

            //log.info("Affichage d'un seul film (avec réalisateur) ---findByDirector(\"Christopher Nolan\")");
            //movieRepository.findByDirector("Christopher Nolan");
        });
    }
}
