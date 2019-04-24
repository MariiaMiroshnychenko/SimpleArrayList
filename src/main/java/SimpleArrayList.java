import java.util.Iterator;

public class SimpleArrayList<E> implements SimpleArrayListMethods<E> {

    public static void main(String[] args) {
        SimpleArrayListMethods<String> strings = new SimpleArrayList<>();

        strings.add("Yo man");
        strings.add("Say \"Hello\"");

        System.out.println(strings.get(1));

        System.out.println(strings.size());

        strings.update(0, "Hi");

        for (String arr : strings) {
            System.out.println(arr);
        }

        strings.delete(0);

        System.out.println(strings.size());

        ArrayListIterator<String> iterator = (ArrayListIterator<String>) strings.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private E[] values;

    private SimpleArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int elementAmountAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, elementAmountAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>(values);
    }
}
