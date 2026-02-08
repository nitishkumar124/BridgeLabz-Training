package multi_threading.download_manager;
import java.util.Random;

class FileDownloader implements Runnable{
	private String fileName;
	
	public FileDownloader(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		for(int i = 0; i <= 100; i += 10) {
			try {
				Thread.sleep(random.nextInt(500) + 200);
			}catch(InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted.");
			}
			
			System.out.println("[" + Thread.currentThread().getName() + "] Downloading " 
			+ fileName + ": " + i + "%");
		}
		
		System.out.println("[" + Thread.currentThread().getName() + "] " 
				+ fileName + " Download complete!");
	}
}
