package es.ulpgc.spotify.downloader;

import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) throws Exception{
        MusicSource source = new Spotify();
        MusicDataBase musicDataBase = new SQLiteStore();
        Map<String, String> artists_ids = Map.of("Ghouljaboy", "00a2IOlewyt2Xk4702wg5d",
                "Craig David","2JyWXPbkqI5ZJa3gwqVa0c",
                "Leigh Nash","0KaOODqnbHxMIZ3qUH5F5n",
                "Quevedo","52iwsT98xCoGgiGntTiR7K",
                "Fiona Apple","3g2kUQ6tHLLbmkV7T4GPtL");
        List<Track> tracks;
        List<Album> albums;
        List<Artist> artists;
        for (String id : artists_ids.values()) {
            artists = source.artistOf(id);
            albums = source.albumsOf(id);
            tracks = source.tracksOf(id);
            for (Artist artist: artists){
                musicDataBase.add(artist);
            }
            for (Album album: albums){
                musicDataBase.add(album);
            }
            for (Track track: tracks){
                musicDataBase.add(track);
            }
        }

    }

}
