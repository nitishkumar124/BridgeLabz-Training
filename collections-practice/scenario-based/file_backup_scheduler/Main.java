package week4_collections.file_backup_scheduler;

public class Main {
    public static void main(String[] args) {

        BackupScheduler scheduler = new BackupScheduler();

        try {
            scheduler.addBackupTask("/documents", 2);
            scheduler.addBackupTask("/system", 5);
            scheduler.addBackupTask("/photos", 3);
            scheduler.addBackupTask("", 4);
        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        scheduler.executeBackups();
    }
}

