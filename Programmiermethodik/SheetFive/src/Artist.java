/**
 * Created by clemenspfister on 04/05/2017.
 */

/*
* (2 Punkte) Erstellen Sie die Klasse Artist. Diese soll einen Artistnamen und pro
* Artist eine Liste von Alben speichern können. Diese Liste soll immer chronologisch
* nach Erscheinungsjahr der Alben sortiert sein, d.h. auch nach jedem Hinzufügen und
* Entfernen von Einträgen (Tipp: Hier werden Sie für die Sortierung den zuvor
* deﬁnierten Comparator der Album-Klasse benöti-gen. Überlegen Sie, wie sie diese
* Inner-Klasse hier ansprechen können.). Fügen Sie zudem Methoden zum Hinzufügen
* und Entfernen von Alben hinzu. Falls Artists verglichen werden müssen, soll dies
* Aufgrund deren Namen (alphabetische Sortierung) erfolgen.
*/

import java.util.Comparator;
import java.util.TreeSet;

public class Artist {
    public String name;
    public TreeSet<Album> albums;

    public Artist() {

    }

    public Artist(String name, TreeSet<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public Artist(String name) {
        this.name = name;
        albums = new TreeSet<Album>(new Album().new AlbumComparator());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAlbum(Album... albumTitle) {
        for (Album title : albumTitle) {
            albums.add(title);
            System.out.println("Title: '" + title + "' has been added.");
        }
    }

    public void removeAlbum(Album albumTitle) {
        if (albums.isEmpty()) {
            System.out.println("There are no albums specified for " + name + ".");
        } else if (!albums.contains(albumTitle)) {
            System.out.println("The album " + albumTitle.getName() + " does not exist for " + name + ".");
        } else {
            albums.remove(albumTitle);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Artist)) {
            System.out.println("Wrong object!");
            return false;
        }
        Artist other = (Artist) obj;
        return (other.name.compareTo(this.name) == 0);
    }

    public TreeSet<Album> getAlbums() {
        return albums;
    }

    class ArtistComparator implements Comparator<Artist> {
        @Override
        public int compare(Artist firstArtist, Artist secondArtist) {
            return firstArtist.name.compareTo(secondArtist.name);
        }
    }
}
