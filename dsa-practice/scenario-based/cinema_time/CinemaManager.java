package week3.cinema_time;
import java.util.ArrayList;
import java.util.List;
public class CinemaManager {
	private List<Movie> movies = new ArrayList<>();
	
	public void addMovie(String mName, String time) throws InvalidTimeFormatException{
		if(!isValidTime(time)) {
			throw new InvalidTimeFormatException("Inavlid Format:" + time);
		}
		movies.add(new Movie(mName, time));
	}
	
	public void searchMovie(String keyword) {
		boolean found = false;
		try {
			for(int i = 0; i < movies.size(); i++) {
				if(movies.get(i).getMName().contains(keyword)) {
					System.out.println(String.format(
							"Found: %s at %s",
							movies.get(i).getMName(),
							movies.get(i).getTime()));
					found = true;
				}
			}
			if(!found) {
				System.out.println("Movie not found");
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Invalid index");
		}
	}
	
	public void displayAllMovies() {
		for(Movie m : movies) {
			System.out.println(String.format(
					"Movies: %s | Time: %s",
					m.getMName(),
					m.getTime()));
		}
	}
	
	public void generateReport() {
		Movie[] movieArray = movies.toArray(new Movie[0]);
		
		System.out.println("Final Report");
		for(Movie m : movieArray) {
			System.out.println(m.getMName() + " - " + m.getTime());
		}
	}
	
	private boolean isValidTime(String time) {
		try {
			String[] parts = time.split(":");
			int hour = Integer.parseInt(parts[0]);
			int minute = Integer.parseInt(parts[1]);
			return hour >= 0 && hour <= 23 && minute >= 0 &&  minute <= 59;
		}catch(Exception e) {
			return false;
		}
	}
}
