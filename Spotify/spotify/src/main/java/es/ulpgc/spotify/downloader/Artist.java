package es.ulpgc.spotify.downloader;

public class Artist {
    String name;
    String genres;
    String id;
    int followers;

    int popularity;

    public Artist(String name, String genres, String id, int followers, int popularity) {
        this.name = name;
        this.genres = genres;
        this.id = id;
        this.followers = followers;
        this.popularity = popularity;
    }
}
