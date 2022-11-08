package es.ulpgc.spotify.downloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLiteStore implements MusicDataBase {
    private final Connection connection;
    public SQLiteStore() throws SQLException{
        connection = DriverManager.getConnection("jdbc:Sqlite:Spotify.db");
        initDataBase();
    }
    public static final String INIT = //sentencia ddl
            "CREATE TABLE IF NOT EXISTS tracks (\n"
                    + "author TEXT,"
                    + "name TEXT,"
                    + "popularity NUMBER,"
                    + "duration_ms NUMBER,"
                    + "explicit BOOLEAN"
                    + ");";

    public static final String INIT2 = //sentencia ddl
            "CREATE TABLE IF NOT EXISTS albums (\n"
                    + "author TEXT,"
                    + "name TEXT,"
                    + "release_date TEXT,"
                    + "uri TEXT,"
                    + "total_tracks NUMBER"
                    + ");";
    public static final String INIT3 = //sentencia ddl
            "CREATE TABLE IF NOT EXISTS artists (\n"
                    + "name TEXT,"
                    + "genres TEXT,"
                    + "id TEXT,"
                    + "followers NUMBER,"
                    + "popularity NUMBER"
                    + ");";
    private void initDataBase() throws SQLException{
        connection.createStatement().execute(INIT);
        connection.createStatement().execute(INIT2);
        connection.createStatement().execute(INIT3);
    }
    public void add(Track track) {
        try {
            connection.createStatement().execute(DMLTranslator.insertStatementOf(track));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void add(Album album) {
        try {
            connection.createStatement().execute(DMLTranslator.insertStatementOf(album));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void add(Artist artist) {
        try {
            connection.createStatement().execute(DMLTranslator.insertStatementOf(artist));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
