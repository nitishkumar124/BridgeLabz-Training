package week4_collections.file_backup_scheduler;

import java.util.PriorityQueue;

public class BackupScheduler {

	private PriorityQueue<BackupTask> queue = new PriorityQueue<>();

	public void addBackupTask(String path, int priority) throws InvalidBackupPathException {

		if (path == null || path.isEmpty()) {
			throw new InvalidBackupPathException("Invalid backup path");
		}

		queue.add(new BackupTask(path, priority));
		System.out.println("Backup task added: " + path);
	}

	public void executeBackups() {
		System.out.println("\nExecuting backups in priority order:");

		while (!queue.isEmpty()) {
			BackupTask task = queue.poll();
			System.out.println("Backing up: " + task.getFolderPath() + " | Priority: " + task.getPriority());
		}
	}
}
