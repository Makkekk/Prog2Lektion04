package opgave03.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListRing<E> implements Ring<E> {
    private final ArrayList<E> items;
    private int currentIndex;


    public ArrayListRing() {
        this.items = new ArrayList<>();
        this.currentIndex = 0;
    }

    @Override
    public void advance() {
        if (!items.isEmpty()) {
            currentIndex = (currentIndex + 1) % items.size(); // Movie to next item circularity
        }
    }

    @Override
    public E getCurrentItem() {
        if (items.isEmpty()) {
            throw new EmptyRingException("Ring is empty");
        }
        return items.get(currentIndex);
    }

    @Override
    public void add(E item) {
        if (items.isEmpty()) {
            items.add(item);
            currentIndex = 0;
        } else {
            int inserIndex = (currentIndex + 1) % items.size();
            items.add(inserIndex, item);
            currentIndex = inserIndex;
        }
    }

    @Override
    public boolean removeItem(E item) {
        int index = items.indexOf(item);
        if (index != -1) {
            items.remove(index);
            if (items.isEmpty()) {
                currentIndex = 0; //Reset index hvis ringen er tom
            } else if (index <= currentIndex) {
                currentIndex = currentIndex % items.size(); //
            }
            return true;
        }
        return false;
    }

    @Override
    public E removeCurrentItem() {
        if (items.isEmpty()) {
            throw new EmptyRingException("Ring is empty");
        }
        E removedItems = items.remove(currentIndex);
        if (!items.isEmpty()) {
            currentIndex = currentIndex % items.size();
        } else {
            currentIndex = 0;
        }
        return removedItems;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
