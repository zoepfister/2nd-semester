import java.util.ArrayList;

public class TestIterator {

    public static void main(String args[]) {
        ArrayList<String> animalList = new ArrayList();
        animalList.add("Horse");
        animalList.add("Lion");
        animalList.add("Tiger");
        animalList.add("Turtle");
        animalList.add("Horse");
        animalList.add("Lion");
        animalList.add("Tiger");
        animalList.add("Turtle");
        animalList.add("Horse");
        animalList.add("Lion");
        animalList.add("Tiger");
        animalList.add("Turtle");
        Animal animal = new Animal(animalList);
        for (String animalObj : animal) {
            System.out.println(animalObj);
        }
        animalList.remove("Turtle");
    }
}