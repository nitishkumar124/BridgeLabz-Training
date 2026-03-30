package level1;

public class VolumeOfEarthInKmAndMile {

	public static void main(String[] args) {

		double kmRadius = 6378;
		double milesRadius = 6378 * 1.6;

		double kmVolume = (4 / 3) * Math.PI * Math.pow(kmRadius, 3);
		double milesVolume = (4 / 3) * Math.PI * Math.pow(milesRadius, 3);
		System.out.println("The volume of earth in cubic kilometers is " + kmVolume + " and cubic miles is " + milesVolume);
	}

}
