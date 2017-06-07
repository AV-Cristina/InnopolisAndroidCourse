/**
 * Created by Cristina on 07.06.2017.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item>{
    private Item[] list;
    private int size = 0;

    public MyArrayList() {
        this.list = (Item[]) new Object[10];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        this.list = (Item[]) new Object[size];
    }

    public void addLast(Item item) {
        int oldCapacity = list.length;
        // проверяем достаточно ли места
        // если недостаточно, то создаем новый массив размерностью newCapacity
        if ((this.size) == oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            Item[] oldList = this.list;
            this.list = (Item[]) new Object[newCapacity];
            // переписываем в новый массив предыдущий массив
            System.arraycopy(oldList, 0, list, 0, size);
        }
        // добавляем элемент
        list[size++] = item;
    }

    public void add(int index, Item item) {
        if (index < 0 || index > list.length)
            throw new IllegalArgumentException("Illegal index: " + index);

        if (index < list.length) {
            int oldCapacity = list.length;
            // проверяем достаточно ли места
            // если недостаточно, то создаем новый массив размерностью newCapacity
            if ((this.size + 1) < oldCapacity) {
                int newCapacity = (oldCapacity * 3) / 2 + 1;
                this.list = (Item[]) new Object[newCapacity];
            }
            Item[] oldList = this.list;
            // переписываем в новый массив начало предыдущего массива
            System.arraycopy(oldList, 0, list, 0, index);
            // добавляем элемент
            list[size++] = item;
            // переписываем в новый массив "хвост" предыдущего массива
            System.arraycopy(oldList, index, list, index + 1, size - index);
        } else if (index == list.length) {
            addLast(item);
        }
    }

    public Item get(int index) {
        return list[index];
    }

    public void remove(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(list, index + 1, list, index, numMoved);
        list[--size] = null;
    }

    public boolean contains(Item item) {
        boolean itContains = false;
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                itContains = true;
                break;
            }
        }
        return itContains;
    }

    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        private int current;

        public MyArrayListIterator() {
            current = 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return current < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = list[current];
            current++;
            return item;
        }
    }
}

