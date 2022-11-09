package es.ulpgc.spotify.downloader;

import java.util.List;

public interface MusicSource {
    List<Track> tracksOf(String id) throws Exception;
    List<Album> albumsOf(String id) throws Exception;
    List<Artist> artistOf(String id) throws Exception;
}
