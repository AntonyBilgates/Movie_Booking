package com.BookingTicket.MovieBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookingTicket.MovieBooking.Entity.Movie;
import com.BookingTicket.MovieBooking.Repository.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // 1. Get all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // 2. Get movies by title
    @GetMapping("/search")
    public List<Movie> getAllMoviesByTitle(@RequestParam String title) {
        return movieRepository.findByTitle(title);
    }

    // 3. Add a new movie
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // 4. Update an existing movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(updatedMovie.getTitle());
                    movie.setGenre(updatedMovie.getGenre());
                    movie.setDuration(updatedMovie.getDuration());
                    Movie savedMovie = movieRepository.save(movie);
                    return ResponseEntity.ok(savedMovie);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Delete a movie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
