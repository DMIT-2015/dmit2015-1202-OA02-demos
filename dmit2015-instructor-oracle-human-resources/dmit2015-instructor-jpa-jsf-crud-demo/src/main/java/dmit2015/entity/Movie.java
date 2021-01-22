package dmit2015.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity                     // This class is map to database table with the same name as the class name
@Table(name = "movies")     // This entity class maps to a database table named movies
public class Movie implements Serializable {

    @Id                 // This is the primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // This primary key field is generated by the database
    private Long id;

    @Column(length = 60, nullable = false)
    @NotBlank(message = "The Title field is required.")
    @Size(min = 3, max = 60, message = "The field Title must be a string with a minimum length of {min} and a maximum length of {max}.")
    private String title;

    @Column(nullable = false)
    @NotNull(message = "The Release Date field is required")
    private LocalDate releaseDate;

    @DecimalMin(value = "1.00",message = "The price must be a number between 0.00 and 100.00.")
    @DecimalMax(value = "100.00",message = "The price must be a number between 0.00 and 100.00.")
    private BigDecimal price;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "The field Genre is required.")
    @Pattern(regexp = "^[A-Z]+[a-zA-Z]*$",  // Must only use letters.
                                            // The first letter is required to be uppercase. White space, numbers, and special characters are not allowed.
            message = "The field Genre must match the regular expression '^[A-Z]+[a-zA-Z]*$'.")
    private String genre;

    @Column(nullable = false, length = 5)
    @NotBlank(message = "The field Rating is required.")
    @Pattern(regexp = "^[A-Z]+[a-zA-Z0-9\"\"'\\s-]*$", // The first character can be an uppercase letter
                                                        // Allows special characters and numbers in subsequent spaces. PG-13 is valid but fails for a Genre
            message = "The field Rating must match the regular expression '^[A-Z]+[a-zA-Z0-9\"\"'\\s-]*$'.")
    private String rating;      // G, PG, PG-13, R, NC-17

    @Version
    private Integer version;
}