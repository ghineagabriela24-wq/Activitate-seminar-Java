package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DatabaseManager.createTable();

        MovieDAO movieDAO = new MovieDAO();

        movieDAO.createMovie(new Movie("Inception", "SF", 2010, 8.8));
        movieDAO.createMovie(new Movie("Titanic", "Drama", 1997, 7.9));
        movieDAO.createMovie(new Movie("The Dark Knight", "Action", 2008, 9.0));

        System.out.println("\nToate filmele:");
        List<Movie> movies = movieDAO.getAllMovies();

        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println("\nCautare film dupa id:");
        Movie foundMovie = movieDAO.getMovieById(1);

        if (foundMovie != null) {
            System.out.println(foundMovie);
        } else {
            System.out.println("Filmul nu a fost gasit.");
        }

        System.out.println("\nActualizare film:");
        Movie updatedMovie = new Movie(1, "Inception Updated", "Science Fiction", 2010, 9.2);
        movieDAO.updateMovie(updatedMovie);

        System.out.println("\nFilme dupa actualizare:");
        movies = movieDAO.getAllMovies();

        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println("\nStergere film:");
        movieDAO.deleteMovie(2);

        System.out.println("\nFilme dupa stergere:");
        movies = movieDAO.getAllMovies();

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}