package week3.cinema_time;

public class Movie {
	private String mName;
	private String time;
	
	public Movie(String mName, String time) {
		this.mName = mName;
		this.time = time;
	}
	
	public String getMName() {
		return mName;
	}
	
	public String getTime() {
		return time;
	}
}
