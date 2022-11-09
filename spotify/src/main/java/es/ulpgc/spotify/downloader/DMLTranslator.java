package es.ulpgc.spotify.downloader;

public class DMLTranslator {
    public static final String INSERT_TRACK = //sentencia dml
            "INSERT INTO tracks(author,name,popularity,duration_ms,explicit) VALUES( '%1$s', '%2$s', %3$d, %4$d, %5$d)";
    public static final String INSERT_ALBUM =
            "INSERT INTO albums(author,name,release_date,uri,total_tracks) VALUES( '%1$s', '%2$s', '%3$s', '%4$s', %5$d)";
    public static final String INSERT_ARTIST =
            "INSERT INTO artists(name,genres,id,followers,popularity) VALUES( '%1$s', '%2$s', '%3$s', %4$d, %5$d)";
    public static String insertStatementOf(Track track){
        return String.format(INSERT_TRACK,
                track.author,
                track.name,
                track.popularity,
                track.duration_ms,
                track.explicit ? 1 : 0
        );
    }
    public static String insertStatementOf(Album album){
        return String.format(INSERT_ALBUM,
                album.author,
                album.name,
                album.release_date,
                album.uri,
                album.total_tracks
        );
    }
    public static String insertStatementOf(Artist artist){
        return String.format(INSERT_ARTIST,
                artist.name,
                artist.genres,
                artist.id,
                artist.followers,
                artist.popularity
        );
    }
}
