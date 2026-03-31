package week6_java8.music_playlist_manager;
class SongAlreadyExistsException extends Exception {
    public SongAlreadyExistsException(String message) {
        super(message);
    }
}