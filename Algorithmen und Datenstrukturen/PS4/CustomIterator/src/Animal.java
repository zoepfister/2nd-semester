import java.util.ArrayList;
import java.util.Iterator;

public class Animal implements Iterable<String> {

    private ArrayList<String> animal = new ArrayList<String>();

    public Animal(ArrayList animal) {
        this.animal = animal;
    }

    public ArrayList getAnimal() {
        return animal;
    }

    @Override
    public Iterator<String> iterator() {
        return new AnimalIterator(this);
    }

}