/**
 * Created by clemenspfister on 04/05/2017.
 */

/*
* Erstellen Sie die Klasse Album. Diese soll einen Albumnamen und pro Album eine Liste von Albumtiteln,
* sowie das Erscheinungsjahr (als Typ Integer genügt) speichern können. Fügen Sie zudem Methoden zum
* Hinzufügen und Entfernen von Titeln hinzu. Um Alben chronologisch sortieren zu können
* (wird später benötigt), verwenden Sie hier eine innere Klasse vom Typ ”Comparator”. Der Vergleich
* soll aufgrund des Erscheinungsjahres erfolgen.
*/

import java.util.ArrayList;
import java.util.Comparator;

public class Album {
    public String name;
    // This is a sorted List where duplicates are allowed
    public ArrayList<String> titles;
    public int releaseYear;

    public Album() {

    }

    // Constructor if there already is a title list
    public Album(String name, ArrayList<String> titles, int releaseYear) {
        this.name = name;
        this.titles = titles;
        this.releaseYear = releaseYear;
    }

    // Constructor if there is no title list
    public Album(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        // Create a new ArrayList for album
        titles = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void addTitle(String... albumTitles) {
        for (String title : albumTitles) {
            titles.add(title);
            System.out.println("Title: '" + title + "' has been added.");
        }
    }

    public void removeTitle(String title) {
        if (titles.isEmpty()) {
            System.out.println("This album has no title.");
        } else if (titles.contains(title)) {
            titles.remove(title);
            System.out.println("Title: '" + title + "' has been removed.");
        } else {
            System.out.println("The title with the name: '" + title + "' is not in this album.");
        }
    }

    public void removeTitle(int index) {
        if (titles.isEmpty()) {
            System.out.println("This album has no title.");
        } else if (index < 0 || index >= titles.size()) {
            System.out.println("Please enter a valid index between 0 and " + titles.size());
        } else {
            titles.remove(index);
            System.out.println("Title with index " + index + " has been removed (" + titles.get(index) + ").");
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    class AlbumComparator implements Comparator<Album> {
        @Override
        public int compare(Album firstAlbum, Album secondAlbum) {
            if (firstAlbum.releaseYear == secondAlbum.releaseYear) {
                return 0;
            } else {
                return firstAlbum.releaseYear < secondAlbum.releaseYear ? -1 : 1;
            }
        }
    }


}
