package tools.dataStructure;

import java.util.ArrayList;

public class Stack <T extends Comparable<T>> {

    ArrayList<T> arr = new ArrayList<T>();
    int size=0;

    public Stack(T value) {
        this.arr.add(value);
        size =1;
    }

    public Stack() {

    }

    public boolean stackIsEmpty()
    {
        return size==0;
    }

    public boolean push (T value)
    {
        arr.add(value);
        size++;

        return true;
    }

    public T pop()
    {
        if(size==0)
            throw new StackOverflowError("Stack is empty");

        T returnValue = arr.get(size-1);
        arr.remove(size-1);
        size--;

        return returnValue;
    }

    public int getSize() {
        return size;
    }


}
