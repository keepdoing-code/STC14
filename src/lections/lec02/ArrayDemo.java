package lections.lec02;

import java.util.Iterator;
import java.util.function.Consumer;


public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i: arr) {
            System.out.println(i);
        }

        for (int anArr : arr) {
            System.out.println(anArr);
        }

        MyArray myArray = new MyArray();

    }
}


class MyArray implements Iterable{
    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }
}