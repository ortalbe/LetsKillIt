package tools.dataStructure;

import java.util.ArrayList;

public class TrieNode implements Comparable {

    private String value;
    private ArrayList<TrieNode> childs;
    private TrieNode parent;

    public TrieNode(String value) {
        this.value = value;
        childs =null;
        parent = null;

    }

    public TrieNode(String value,TrieNode parent) {
        this.value = value;
        childs =null;
        this.parent = parent;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<TrieNode> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<TrieNode> childs) {
        this.childs = childs;
    }

    public boolean addChild (TrieNode node)
    {
        if(childs==null)
            childs = new ArrayList<TrieNode>() ;
       childs.add(node);
       return true;
    }

    public boolean addChild (String nodeValue)
    {
        childs.add(new TrieNode(nodeValue));
        return true;
    }

    public TrieNode getParent() {
        return parent;
    }

    public void setParent(TrieNode parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof  TrieNode))
            return -1;
        return value.compareTo(((TrieNode) o).getValue());
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "value='" + value + '\'' +
                '}';
    }


}
