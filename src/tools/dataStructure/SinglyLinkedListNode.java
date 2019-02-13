package tools.dataStructure;

public class SinglyLinkedListNode {


    private int data;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        boolean mergeFound=false;
        int mergeValue=0;
        SinglyLinkedListNode currentNodeHead1 = head1;
        SinglyLinkedListNode currentNodeHead2 = head2;

            while(currentNodeHead1!=null && !mergeFound) {
                while (currentNodeHead2 != null && !mergeFound) {
                    if (currentNodeHead1.data == currentNodeHead2.data) {
                        if(chneckMerge(currentNodeHead1,currentNodeHead2)) {
                            mergeFound = true;
                            mergeValue = currentNodeHead1.data;
                        }
                    }
                    currentNodeHead2 = currentNodeHead2.next;
                }
                currentNodeHead2=head2;
                currentNodeHead1=currentNodeHead1.next;

        }
        return mergeValue;

    }

    private static boolean chneckMerge(SinglyLinkedListNode currentNodeHead1, SinglyLinkedListNode currentNodeHead2) {

        while(currentNodeHead1!=null && currentNodeHead2!=null)
        {
            if(currentNodeHead1.data!=currentNodeHead2.data)
                return false;

            currentNodeHead1=currentNodeHead1.next;
            currentNodeHead2=currentNodeHead2.next;
        }

        if(currentNodeHead2!=null || currentNodeHead1!=null)
            return false;

        return true;
    }

    public static SinglyLinkedListNode insert (SinglyLinkedListNode head, int value)
    {
        if(head==null)
            return new SinglyLinkedListNode(value);

        SinglyLinkedListNode temp = head;
        while(temp.next!=null)
            temp=temp.next;

        temp.next = new SinglyLinkedListNode(value);

        return head;
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode temp = head;

        for(int i=0;i<position-1;i++)
        {
            if(temp.next!=null)
                temp=temp.next;
        }

        SinglyLinkedListNode nextTemp = temp.next;
        temp.next = new SinglyLinkedListNode(data);

        temp.next.next=nextTemp;

        return head;

    }

    public static boolean hasCycle(SinglyLinkedListNode head) {

        if(head==null)
            return false;


        SinglyLinkedListNode tempOneGap = head;
        SinglyLinkedListNode tempTwoGap = head.next;

        while(tempOneGap!=null)
        {
            if(tempTwoGap.next!=null && tempTwoGap.next.next!=null)
                tempTwoGap=tempTwoGap.next.next;
            else
                return false;

            if(tempTwoGap==tempOneGap)
                return true;

            tempOneGap=tempOneGap.next;
        }

        return false;

    }
}
