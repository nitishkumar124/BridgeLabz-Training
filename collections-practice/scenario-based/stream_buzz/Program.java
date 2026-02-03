package week4_collections.stream_buzz;

import java.util.*;

import javax.swing.text.html.CSS;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Program program = new Program();
//		boolean flag = true;
		while (true) {
			System.out.println(
					"1. Register Creator\r\n" + "2. Show Top Posts\r\n" + "3. Calculate Average Likes\r\n" + "4. Exit");
			System.out.println("\nEnter your choice:");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter Creator Name:");
				String creatorName = sc.nextLine();
				System.out.println("Enter weekly likes (Week 1 to 4):");
				int i = 4;
				double[] weeklyLikes = new double[4];
				while (i > 0) {
					weeklyLikes[4 - i--] = sc.nextDouble();
					sc.nextLine();
				}
				engagementBoard.add(new CreatorStats(creatorName, weeklyLikes));
				System.out.println("Creator registered successfully");
				break;
			case 2:
				System.out.println("Enter like threshold:");
				double likeThreshold = sc.nextDouble();
				sc.nextLine();
				Map<String, Integer> topPosts = program.getTopPostCounts(engagementBoard, likeThreshold);
				for (Map.Entry<String, Integer> entry : topPosts.entrySet())
					System.out.println(entry.getKey() + " - " + entry.getValue());

				break;
			case 3:
				System.out.println("Overall average weekly likes: " + (int) program.CalculateAverageLikes());
				break;
			case 4:
//				flag = false;
//				break;
				return;
			}
			System.out.println();
		}
	}

	public static List<CreatorStats> engagementBoard = new ArrayList<>();

	public void RegisterCreator(CreatorStats record) {
		engagementBoard.add(record);
	}

	public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
		Map<String, Integer> topPosts = new HashMap<>();

		for (CreatorStats record : records) {
			int count = 0;

			for (double likes : record.weeklyLikes)
				if (likes >= likeThreshold)
					count++;

			if (count > 0)
				topPosts.put(record.creatorName, count);

		}
		return topPosts;
	}

	public double CalculateAverageLikes() {
		double totalLikes = 0;
		for (CreatorStats record : engagementBoard)
			for (double likes : record.weeklyLikes)
				totalLikes += likes;

		return totalLikes / (engagementBoard.size() * 4);

	}
}
