package tools.dataStructure;

import java.util.ArrayList;

public class Queue<T extends Comparable<T>>  {

    ArrayList<T> arr = new ArrayList<T>();
    int size=0;

    public Queue(T value) {
        this.arr.add(value);
        size++;
    }

    public Queue()
    {

    }

    public boolean enqueue (T value)
    {
        this.arr.add(value);
        size++;

        return true;
    }

    public T dequeue ()
    {
        if(size==0)
            throw new StringIndexOutOfBoundsException("Queue is empty");

        T value = this.arr.get(0);
        this.arr.remove(0);

        size--;

        return value;
    }

    public int getSize() {
        return size;
    }
}
