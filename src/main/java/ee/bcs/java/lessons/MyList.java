package ee.bcs.java.lessons;

import java.util.*;

public class MyList implements List {

    private final Object[] array = new Object[1000];
    int index = 0;

    @Override
    public boolean add(Object o) {
        array[index] = o;
        index++;
        return true;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean remove(Object o) {
        int temp = 0;
        for (int i = 0; i < index; i++) {
            if (o.equals(array[i])) {
                temp++;
                for (int j = i; j < index-1; j++) {
                    array[j] = array[j+1];
                }
            }
        }
        index = index - temp;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < index; i++) {
            if (o.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
