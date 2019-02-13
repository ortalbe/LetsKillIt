package tools.dataStructure;

public class DoublyLinkedListNode {

    private int data;
    private DoublyLinkedListNode next;
    private DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
        this.data = data;
        next =null;
        prev=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public DoublyLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode prev) {
        this.prev = prev;
    }

    public  static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        if(head==null)
            head = new DoublyLinkedListNode(data);

        else
        {
            DoublyLinkedListNode largerNode =head;
            DoublyLinkedListNode smallerNode =head;
                while(largerNode!=null && largerNode.data<data) {
                    smallerNode = largerNode;
                    largerNode = largerNode.next;
                }

                if(largerNode==smallerNode || largerNode==null)
                {
                    DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
                    if(smallerNode.data<data) {
                        smallerNode.next=temp;
                        temp.prev=smallerNode;
                    }
                    else {
                        smallerNode.prev=temp;
                        temp.next=smallerNode;
                        head=temp;
                    }
                }
                else {
                    DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
                    temp.prev=smallerNode;
                    temp.next=largerNode;
                    if (smallerNode != null)
                        smallerNode.next=temp;
                    if (largerNode != null)
                        largerNode.prev=temp;
                }


                }


        return head;
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode headReversed =null,current=null;

        DoublyLinkedListNode temp=head;
        if(head!=null)
        {
            while(temp.next!=null)
            {
                temp=temp.next;
            }

            headReversed = new DoublyLinkedListNode((temp.data));
            current = headReversed;
           while(temp.prev!=null)
           {
               current.next=new DoublyLinkedListNode((temp.prev.data));
               current.next.prev=current;
               current=current.next;
               temp=temp.prev;


           }
        }

        return headReversed;
    }


}
