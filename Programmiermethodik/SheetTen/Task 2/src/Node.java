/**
 * Created by clemenspfister on 15/06/2017.
 */
public abstract class Node {
    public Folder parent;
    public String name;

    public Node(String name){
        parent = null;
        this.name = name;
    }
}
