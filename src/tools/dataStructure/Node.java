package tools.dataStructure;

public class Node  <T extends Comparable<T>> implements Comparable<Node<T>> {


    T value;
    String key;

    public Node() {
    }

    public Node(String key, T value) {
        this.value = value;
        this.key = key;
    }

    public Node(Node<T> node) {
        this.value = node.getValue();
        this.key = node.getKey();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int compareTo(Node<T> o)
    {
        if(o==this)
            return 0;
        else
        {
            Node<T> temp = (Node<T>) o;
            if(temp.getValue()!=value)
                return value.compareTo(temp.getValue());
            else
               return key.compareTo(o.getKey());
        }

    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", key='" + key + '\'' +
                '}';
    }
}
