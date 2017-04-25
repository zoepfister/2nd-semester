import java.util.ArrayList;
import java.util.Iterator;

public class AnimalIterator<String> implements Iterator<Object> {

    private ArrayList<?> animal;
    private int position;

    public AnimalIterator(Animal animalBase) {
        this.animal = animalBase.getAnimal();
    }

    @Override
    public boolean hasNext() {
        if (position < animal.size())
            return true;
        else
            return false;
    }

    @Override
    public Object next() {
        Object aniObj = animal.get(position);
        position += 2;
        return aniObj;
    }

    @Override
    public void remove() {
        animal.remove(position);
    }

}