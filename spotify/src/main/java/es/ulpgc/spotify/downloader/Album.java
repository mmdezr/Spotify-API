package es.ulpgc.spotify.downloader;

public class Album {
    String author;
    String name;
    String release_date;
    String uri;
    int total_tracks;

    public Album(String author, String name, String release_date, String uri, int total_tracks) {
        this.author = author;
        this.name = name;
        this.release_date = release_date;
        this.uri = uri;
        this.total_tracks = total_tracks;
    }
}
