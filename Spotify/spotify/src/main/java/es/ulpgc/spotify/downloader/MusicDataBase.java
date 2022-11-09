package es.ulpgc.spotify.downloader;

public interface MusicDataBase {
    void add(Track track);
    void add(Album album);
    void add(Artist artist);
}
