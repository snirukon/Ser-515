import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
public class ListIterator {
    public ListIterator() {
        System.out.println("iterator design pattern");
    }

    public static Iterator<Integer> range(int start, int end) {
        return new Iterator<>() {
            private int i = start;
            @Override
            public boolean hasNext() {
                return i < end;
            }
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return i++;
            }
        };
    }

    public static void iterate(ArrayList<String> pname) {
        System.out.println("Menu");
        var iterator = range(0, pname.toArray().length);
        while (iterator.hasNext()) {
            System.out.println(pname.get(iterator.next()));
        }
    }
}
