package com.BookingTicket.MovieBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookingTicket.MovieBooking.Entity.Movie;
import com.BookingTicket.MovieBooking.Repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    public List<Movie> getMoviesByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie movie = getMovieById(id);
        movie.setTitle(updatedMovie.getTitle());
        movie.setGenre(updatedMovie.getGenre());
        movie.setDuration(updatedMovie.getDuration());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Movie not found with id: " + id);
        }
        movieRepository.deleteById(id);
    }
}
