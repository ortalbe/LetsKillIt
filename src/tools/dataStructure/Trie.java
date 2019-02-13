package tools.dataStructure;

public class Trie {

    private TrieNode head;

    public Trie(String value) {
       this.head = new TrieNode("") ;
       this.insert(value);
    }

    public Trie() {
        this.head = new TrieNode("") ;
       }

    public boolean insert(String value)
    {
        TrieNode tempHead=head;
        boolean nodeExist;
        for(int i=0;i<value.length();i++) {
            nodeExist=false;
            if(tempHead.getChilds()!=null)
            for (TrieNode currentNode : tempHead.getChilds()) {
                if (currentNode.getValue().equals(value.substring(0,i+1))) {
                    nodeExist=true;
                    tempHead=currentNode;
                    break;
                }
            }
            if(!nodeExist)
            {
                TrieNode newNode = new TrieNode(value.substring(0,i+1),tempHead);
                tempHead.addChild(newNode);
                tempHead=newNode;
            }

        }

        return true;
    }


    public boolean searchWord(String word)
    {
        boolean wordExist=true;
        TrieNode currentNode = head;
        boolean letterExist;
        for(int i=0;i<word.length();i++)
        {
            letterExist=false;
            for(TrieNode node:currentNode.getChilds())
            {
                if(node.getValue().compareTo(word.substring(0,i+1))==0) {
                    currentNode=node;
                    letterExist = true;
                    break;
                }
            }
            if(!letterExist)
            {
                wordExist=false;
                break;
            }

        }

        return wordExist;
    }

    public boolean removeWord(String word)
    {
        boolean wordRemoved = false;
        if(searchWord(word))
        {
            wordRemoved=removeNode(head,word);
        }

        return wordRemoved;
    }

    private boolean  removeNode(TrieNode head, String word) {


        TrieNode leaf= findLeaf(head,word);
        if(leaf==null)
            return false;
        removeLeaf(leaf);

        return true;
    }

    private void removeLeaf(TrieNode leaf) {
        while(leaf.getParent()!=null && leaf.getParent().getChilds().size()==1)
            leaf=leaf.getParent();

      leaf.getParent().getChilds().remove(leaf);

    }

    private TrieNode findLeaf(TrieNode head, String word) {

        TrieNode currentNode = head;

        for(int i=0;i<word.length();i++)
        {
            for(TrieNode node:currentNode.getChilds())
            {
                if(node.getValue().compareTo(word.substring(0,i+1))==0) {
                    currentNode=node;
                    break;
                }
            }


        }

        if(!checkOneWord(currentNode))
            return null;
        else
            return currentNode;
    }

    private boolean checkOneWord(TrieNode currentNode) {
        while(currentNode.getChilds()!=null)
        {
            if(currentNode.getChilds().size()!=1)
                return false;
            currentNode=currentNode.getChilds().get(0);
        }

        return true;
    }

}
