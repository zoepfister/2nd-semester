/**
 * Created by clemenspfister on 15/06/2017.
 */
public class Test {
    public static void main(String[] args) {
        Folder DataSystem = new Folder("DS");

        Folder Folder1 = new Folder("Folder 1");
        Folder Folder2 = new Folder("Folder 2");
        Folder Folder3 = new Folder("Folder 3");
        Folder Folder4 = new Folder("Folder 4");
        Folder Folder5 = new Folder("Folder 5");
        Folder Folder6 = new Folder("Folder 6");
        Folder Folder7 = new Folder("Folder 7");
        Folder Folder8 = new Folder("Folder 8");

        DataSystem.addFolder(Folder1);
        DataSystem.addFolder(Folder2);
        Folder2.addFolder(Folder3);
        DataSystem.addFolder(Folder8);

        DataSystem.printFolderStructure();
    }
}
