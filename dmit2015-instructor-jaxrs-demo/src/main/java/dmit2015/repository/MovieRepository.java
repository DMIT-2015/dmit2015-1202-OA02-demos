package dmit2015.repository;

import dmit2015.entity.Movie;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class MovieRepository {

    @PersistenceContext //(unitName = "h2database-jpa-pu")
    private EntityManager em;

    public void add(Movie newMovie) {
//        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//        Set<ConstraintViolation<Movie>> constraintViolations = validator.validate(newMovie);
//        if (constraintViolations.size() == 0) {
//            em.persist(newMovie);
//        } else {
//            throw new RuntimeException("....");
//        }
        em.persist(newMovie);
    }

    public void update(Movie updatedMovie) {
        Optional<Movie> optionalMovie = findById(updatedMovie.getId());
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setPrice(updatedMovie.getPrice());
            existingMovie.setRating(updatedMovie.getRating());
            existingMovie.setReleaseDate(updatedMovie.getReleaseDate());
            existingMovie.setVersion(updatedMovie.getVersion());
            em.merge(existingMovie);
            em.flush();
        }
    }

    public void remove(Movie existingMovie) {
        em.remove(em.merge(existingMovie));
        em.flush();
    }

    public void remove(Long movieID) {
        Optional<Movie> optionalMovie = findById(movieID);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            remove(existingMovie);
        }
    }

    public Optional<Movie> findById(Long movieID) {
        Optional<Movie> optionalMovie = Optional.empty();
        try {
            Movie querySingleResult = em.find(Movie.class, movieID);
            if (querySingleResult != null) {
                optionalMovie = Optional.of(querySingleResult);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return optionalMovie;
    }

    public List<Movie> findAll() {
        return em.createQuery(
                "SELECT m FROM Movie m "
                , Movie.class)
                .getResultList();
    }

    public List<Movie> findAllOrderByTitle() {
        return em.createQuery(
                "SELECT m FROM Movie m ORDER BY m.title"
                , Movie.class)
                .getResultList();
    }

}