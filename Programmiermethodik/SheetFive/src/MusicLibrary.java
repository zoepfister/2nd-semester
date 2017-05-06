import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by clemenspfister on 05/05/2017.
 */
public class MusicLibrary {
    public TreeSet<Artist> artists;
    // String will be the music title;
    private HashMap<String, TreeSet<Artist>> index;

    public MusicLibrary() {
        artists = new TreeSet<>(new Artist().new ArtistComparator());
        index = new HashMap<>(0);
    }

    private void refreshIndex() {
        index.clear();
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                for (int i = 0; i < album.titles.size(); i++) {
                    TreeSet<Artist> titleArtists = new TreeSet<Artist>(new Artist().new ArtistComparator());
                    titleArtists.add(artist);
                    index.put(album.titles.get(i), titleArtists);
                }
            }
        }
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
        System.out.println("Artist: '" + artist.getName() + "' has been added.");
        refreshIndex();
    }

    public TreeSet<Artist> getArtists() {
        return artists;
    }

    public TreeSet<Artist> searchArtistByTitle(String title) {
        TreeSet<Artist> titleArtists = new TreeSet<Artist>(new Artist().new ArtistComparator());
        for (Artist artist : artists) {
            if (index.containsKey(title)) {
                Artist titleArtist = index.get(title).first();
                titleArtists.add(titleArtist);
            }
        }
        return titleArtists;
    }

    public TreeSet<Artist> searchArtistWithoutIndex(String title) {
        TreeSet<Artist> titleArtists = new TreeSet<Artist>(new Artist().new ArtistComparator());
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                for (int i = 0; i < album.titles.size(); i++) {
                    if (album.titles.get(i).equals(title)) {
                        titleArtists.add(artist);
                    }
                }
            }
        }
        return titleArtists;
    }


}
