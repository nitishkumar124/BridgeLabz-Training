package multi_threading.download_manager;

public class Main {
	public static void main(String[] args) {
		Thread t1 = new Thread(new FileDownloader("Document.pdf"));
		Thread t2 = new Thread(new FileDownloader("Image.jpg"));
		Thread t3 = new Thread(new FileDownloader("Video.mp4"));
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		
		System.out.println("All downloads completed!");
	}
}
