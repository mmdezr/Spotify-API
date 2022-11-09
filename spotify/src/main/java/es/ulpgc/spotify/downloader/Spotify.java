package es.ulpgc.spotify.downloader;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Spotify implements MusicSource {

    @Override
    public List<Track> tracksOf (String id) throws Exception{
        SpotifyAccessor accessor = new SpotifyAccessor();
        List<Track> tracks = new ArrayList<>();
        String json = accessor.get("/artists/" + id + "/top-tracks", Map.of("country", "ES"));
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        JsonArray tracks_json = jsonObject.get("tracks").getAsJsonArray();
        for(JsonElement element : tracks_json){
            JsonArray author = element.getAsJsonObject().get("artists").getAsJsonArray();
            String name = element.getAsJsonObject().get("name").getAsString().replace("'","");
            int popularity = element.getAsJsonObject().get("popularity").getAsInt();
            int duration = element.getAsJsonObject().get("duration_ms").getAsInt();
            boolean explicit = element.getAsJsonObject().get("explicit").getAsBoolean();
            JsonArray NameArtist = new JsonArray();
            for (JsonElement element1 : author){
                String artists = element1.getAsJsonObject().get("name").getAsString();
                NameArtist.add(artists);
            }
            tracks.add(new Track(NameArtist.toString().replace("'",""), name, popularity, duration, explicit));
        }
        return tracks;
        }

    @Override
    public List<Album> albumsOf (String id) throws Exception{
        SpotifyAccessor accessor = new SpotifyAccessor();
        List<Album> albums = new ArrayList<>();
        String json = accessor.get("/artists/" + id + "/albums", Map.of("country", "ES"));
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        JsonArray items = jsonObject.get("items").getAsJsonArray();
        for(JsonElement item : items){
            String name = item.getAsJsonObject().get("name").getAsString().replace("'","");
            JsonArray author = item.getAsJsonObject().get("artists").getAsJsonArray();
            JsonArray NameArtist = new JsonArray();
            String uri = item.getAsJsonObject().get("uri").getAsString();
            String release_date = item.getAsJsonObject().get("release_date").getAsString();
            int total_tracks = item.getAsJsonObject().get("total_tracks").getAsInt();
            for(JsonElement item1 : author){
                String artists = item1.getAsJsonObject().get("name").getAsString();
                NameArtist.add(artists);
            }
            albums.add(new Album(NameArtist.toString().replace("'",""), name, release_date, uri, total_tracks));
        }
        return albums;
        }
    @Override
    public List<Artist> artistOf (String id) throws Exception{
        SpotifyAccessor accessor = new SpotifyAccessor();
        List<Artist> artists = new ArrayList<>();
        String json = accessor.get("/artists/" + id, Map.of("country", "ES"));
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        String name = jsonObject.get("name").getAsString();
        JsonArray genres = jsonObject.get("genres").getAsJsonArray();
        String Id = jsonObject.get("id").getAsString();
        int followers = jsonObject.get("followers").getAsJsonObject().get("total").getAsInt();
        int popularity = jsonObject.get("popularity").getAsInt();
        artists.add(new Artist(name, genres.toString(), Id, followers, popularity));
        return artists;
    }
}
