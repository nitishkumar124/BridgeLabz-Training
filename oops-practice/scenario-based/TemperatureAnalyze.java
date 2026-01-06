package week2;

import java.util.*;

public class TemperatureAnalyze {

	static void getAverageTemperaturePerDay(float[][] week) {
		float[] avgTempPerDay = new float[7];
		for (int i = 0; i < 7; i++) {
			float sum = 0;
			for (int j = 0; j < 24; j++) {
				sum += week[i][j];
			}
			avgTempPerDay[i] = Math.round(sum / 7);
		}
		System.out.println("Average Temperature on all days: ");
		for (int i = 0; i < 7; i++) {
			System.out.println(getDayName(i) + ": " + avgTempPerDay[i]);			
		}
		System.out.println();
	}

	static float[][] getTemperatureData() {
		float[][] week = new float[7][24];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 24; j++) {
				float temp = (float) Math.random() * 100 - 30;
				week[i][j] = temp;
			}
		}
		return week;
	}

	static String getDayName(int d) {
		switch (d) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tueday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Staurday";
		}
		return "";
	}

	static void getHottestAndColdestDay(float[][] week) {
		float hottestDay = Float.MIN_VALUE;
		float coldestDay = Float.MAX_VALUE;
		int hottestDayIndex = 0;
		int coldestDayIndex = 0;
		for (int i = 0; i < 7; i++) {
			float sum = 0;
			for (int j = 0; j < 24; j++) {
				sum += week[i][j];
			}
			if (hottestDay < sum) {
				hottestDay = sum;
				hottestDayIndex = i;
			}
			if (sum < coldestDay) {
				coldestDay = sum;
				coldestDayIndex = i;
			}
		}
		System.out.println("Hottest Day: " + getDayName(hottestDayIndex));
		System.out.println("Coldest Day: " + getDayName(coldestDayIndex));
	}

	public static void main(String[] args) {
		float[][] week = getTemperatureData();
		getAverageTemperaturePerDay(week);
		getHottestAndColdestDay(week);
	}
}
