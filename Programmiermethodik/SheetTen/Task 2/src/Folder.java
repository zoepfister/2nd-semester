import java.util.ArrayList;
import java.util.List;

/**
 * Created by clemenspfister on 15/06/2017.
 */
public class Folder extends Node{
    List<Folder> folderList;

    public Folder(String name) {
        super(name);
        folderList = new ArrayList<>();
    }

    public void addFolder(Folder child){
        child.parent = this;
        folderList.add(child);
    }

    public void removeFolder(Folder folder){
        folder.parent = null;
        folderList.remove(folder);
    }

}

