package dmit2015.view;

import dmit2015.entity.Movie;
import dmit2015.repository.MovieRepository;
import lombok.Getter;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("currentMovieListController")    // allows you access an object of this class using expression language (EL)
@ViewScoped // class must implement Serializable
public class MovieListController implements Serializable {

    private Logger logger = Logger.getLogger(MovieListController.class.getSimpleName());

    @Inject
    private MovieRepository _movieRepository;

    @Getter
    private List<Movie> movies;

    @PostConstruct  // execute this method after DI (e.g @Inject) is complete
    void init() {
        try {
            movies = _movieRepository.findAll();
        } catch (Exception ex) {
            Messages.addGlobalFatal("Unable to fetch movies");
            logger.info(ex.getMessage());
        }
    }

}
