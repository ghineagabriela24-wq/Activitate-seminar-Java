package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public void createMovie(Movie movie) {
        String sql = "INSERT INTO movies(title, genre, release_year, rating) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setInt(3, movie.getReleaseYear());
            statement.setDouble(4, movie.getRating());

            statement.executeUpdate();
            System.out.println("Filmul a fost adaugat.");

        } catch (SQLException e) {
            System.out.println("Eroare la adaugarea filmului: " + e.getMessage());
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";

        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getInt("release_year"),
                        resultSet.getDouble("rating")
                );

                movies.add(movie);
            }

        } catch (SQLException e) {
            System.out.println("Eroare la citirea filmelor: " + e.getMessage());
        }

        return movies;
    }

    public Movie getMovieById(int id) {
        String sql = "SELECT * FROM movies WHERE id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getInt("release_year"),
                        resultSet.getDouble("rating")
                );
            }

        } catch (SQLException e) {
            System.out.println("Eroare la cautarea filmului: " + e.getMessage());
        }

        return null;
    }

    public void updateMovie(Movie movie) {
        String sql = "UPDATE movies SET title = ?, genre = ?, release_year = ?, rating = ? WHERE id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setInt(3, movie.getReleaseYear());
            statement.setDouble(4, movie.getRating());
            statement.setInt(5, movie.getId());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Filmul a fost actualizat.");
            } else {
                System.out.println("Nu exista film cu acest id.");
            }

        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea filmului: " + e.getMessage());
        }
    }

    public void deleteMovie(int id) {
        String sql = "DELETE FROM movies WHERE id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Filmul a fost sters.");
            } else {
                System.out.println("Nu exista film cu acest id.");
            }

        } catch (SQLException e) {
            System.out.println("Eroare la stergerea filmului: " + e.getMessage());
        }
    }
}