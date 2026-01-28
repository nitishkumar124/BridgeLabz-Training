package week4_collections.file_backup_scheduler;

@SuppressWarnings("serial")
public class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

