package linked_list;

import java.util.*;

public class SocialMediaFriendsConnections {
	public static void main(String[] args) {
		SocialNetwork fb = new SocialNetwork();

		fb.addUser(1, "Alice", 25);
		fb.addUser(2, "Bob", 28);
		fb.addUser(3, "Charlie", 22);
		fb.addUser(4, "David", 26);

		fb.addFriendship(1, 2); 
		fb.addFriendship(1, 3); 
		fb.addFriendship(2, 3); 
		fb.addFriendship(2, 4); 

		fb.displayFriends(1);
		fb.findMutualFriends(1, 2); 
		fb.searchAndStats("Bob");
	}
}

class User {
	int userId;
	String name;
	int age;
	List<Integer> friendIds; 
	User next;

	public User(int userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.friendIds = new ArrayList<>();
		this.next = null;
	}
}

class SocialNetwork {
	private User head;

	// Add a new user to the platform
	public void addUser(int id, String name, int age) {
		User newUser = new User(id, name, age);
		if (head == null) {
			head = newUser;
		} else {
			User temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = newUser;
		}
	}

	// Find user helper method
	private User findUser(int id) {
		User temp = head;
		while (temp != null) {
			if (temp.userId == id)
				return temp;
			temp = temp.next;
		}
		return null;
	}

	// Add friend connection (Bi-directional)
	public void addFriendship(int id1, int id2) {
		User u1 = findUser(id1);
		User u2 = findUser(id2);

		if (u1 != null && u2 != null) {
			if (!u1.friendIds.contains(id2)) {
				u1.friendIds.add(id2);
				u2.friendIds.add(id1);
				System.out.println("Friendship added between " + u1.name + " and " + u2.name);
			}
		} else {
			System.out.println("One or both users not found.");
		}
	}

	// Remove friend connection
	public void removeFriendship(int id1, int id2) {
		User u1 = findUser(id1);
		User u2 = findUser(id2);

		if (u1 != null && u2 != null) {
			u1.friendIds.remove(Integer.valueOf(id2));
			u2.friendIds.remove(Integer.valueOf(id1));
			System.out.println("Friendship removed.");
		}
	}

	// Find Mutual Friends
	public void findMutualFriends(int id1, int id2) {
		User u1 = findUser(id1);
		User u2 = findUser(id2);

		if (u1 == null || u2 == null)
			return;

		System.out.print("Mutual friends of " + u1.name + " and " + u2.name + ": ");
		boolean found = false;
		for (int friendId : u1.friendIds) {
			if (u2.friendIds.contains(friendId)) {
				User mutual = findUser(friendId);
				System.out.print(mutual.name + " ");
				found = true;
			}
		}
		if (!found)
			System.out.print("None");
		System.out.println();
	}

	// Display all friends of a user
	public void displayFriends(int id) {
		User u = findUser(id);
		if (u == null)
			return;

		System.out.print(u.name + "'s Friends: ");
		for (int fId : u.friendIds) {
			User friend = findUser(fId);
			System.out.print(friend.name + " (" + fId + ") ");
		}
		System.out.println();
	}

	// Search user and Count friends
	public void searchAndStats(String query) {
		User temp = head;
		while (temp != null) {
			if (temp.name.equalsIgnoreCase(query) || String.valueOf(temp.userId).equals(query)) {
				System.out.println(
						"User: " + temp.name + " | Age: " + temp.age + " | Total Friends: " + temp.friendIds.size());
				return;
			}
			temp = temp.next;
		}
		System.out.println("User not found.");
	}
}
