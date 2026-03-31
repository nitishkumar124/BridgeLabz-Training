package stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class MovieRanker {
	public static void main(String[] args) {
		List<Movie> movies = Arrays.asList(new Movie("Inception", 2010, 8.8), new Movie("The Dark Knight", 2008, 9.0),
				new Movie("Interstellar", 2014, 8.6), new Movie("Pulp Fiction", 1994, 8.9),
				new Movie("The Matrix", 1999, 8.7), new Movie("Parasite", 2019, 8.6),
				new Movie("The Godfather", 1972, 9.2));

		List<Movie> topMovies = movies.stream()
				// 1. Filter: Let's say we only want movies from 1990 onwards
				.filter(m -> m.releaseYear() >= 1990)

				// 2. Sort: Highest rating first, then by year for ties
				.sorted(Comparator.comparingDouble(Movie::rating).reversed().thenComparingInt(Movie::releaseYear)
						.reversed())

				// 3. Limit: Grab the top 5
				.limit(5).collect(Collectors.toList());

		// Output results
		topMovies.forEach(m -> System.out.println(m.rating() + " | " + m.releaseYear() + " | " + m.title()));
	}
}

class Movie {
	private String title;
	private int releaseYear;
	private double rating;

	public String title() {
		return title;
	}

	public int releaseYear() {
		return releaseYear;
	}

	public double rating() {
		return rating;
	}

	public Movie(String title, int releaseYear, double rating) {
		this.title = title;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}
}