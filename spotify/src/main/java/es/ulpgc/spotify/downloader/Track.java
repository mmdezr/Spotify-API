package es.ulpgc.spotify.downloader;

public class Track {
    String author;
    String name;
    int popularity;
    int duration_ms;
    boolean explicit;

    public Track(String author, String name, int popularity, int duration_ms, boolean explicit) {
        this.author = author;
        this.name = name;
        this.popularity = popularity;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
    }
}
