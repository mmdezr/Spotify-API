package es.ulpgc.spotify.downloader;

import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) throws Exception{
        MusicSource source = new Spotify();
        MusicDataBase musicDataBase = new SQLiteStore();
        Map<String, String> artists_ids = Map.of("David Guetta", "1Cs0zKBU1kc0i8ypK3B9ai",
                "Antonio Orozco","1ADdpen72RPuafRcv0YRBf",
                "Quevedo","52iwsT98xCoGgiGntTiR7K",
                "Ice Cube","3Mcii5XWf6E0lrY3Uky4cA",
                "Bruno Mars","0du5cEVh5yTK9QJze8zA0C",
                "Benito Cabrera","39K3jSxEoYmv6TewH9lJBG",
                "Bruce Springsteen","3eqjTLE0HfPfh78zjh6TqT",
                "Enya","6uothxMWeLWIhsGeF7cyo4",
                "Luciano Pavarotti","0Y8KmFkKOgJybpVobn1onU",
                "Celia Cruz","2weA6hhVqTIN2gSn9PUB9U");
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
