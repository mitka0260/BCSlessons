package ee.bcs.java.lessons;

import java.util.*;

/*
    Loo klass mis implementeerib java.util.List-i
    Implementeeri meetodid:
        add(Object a);
        contains(Object o);
        size();
        remove(Object o);
     */

public class DifficultExercise implements List {

    public static void main(String[] args) {
        List<Ruut> ruutList = new ArrayList<>();
        Ruut a = new Ruut(3, 5, 7);
        ruutList.add(a);
        Ruut b = new Ruut(4, 6, 8);
        ruutList.add(b);
        Ruut c = new Ruut(5, 7, 9);
        ruutList.add(c);
        System.out.println("The size of the List is " + ruutList.size());
        System.out.println();

        for (int i = 0; i < ruutList.size(); i++)
            System.out.println(ruutList.get(i).getX() + " x " + ruutList.get(i).getY() + " ja pindala on " + ruutList.get(i).pindala());
        System.out.println();

        System.out.println("List contains a - " + ruutList.contains(a));
        System.out.println("List contains c - " + ruutList.contains(c));
        ruutList.remove(c);
        System.out.println("List contains c - " + ruutList.contains(c));
    }

    @Override
    public int size() {
        System.out.println("Override method was used ");
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
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
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
    public Object get(int index) {
        return null;
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
