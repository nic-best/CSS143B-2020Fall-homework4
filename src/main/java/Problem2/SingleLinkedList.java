package Problem2;

public class SingleLinkedList {
    private ListNode head;
    private int size;

    public ListNode getHead() {
        return head;
    }

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    public SingleLinkedList(int[] data) {
        this();
        if (data == null || data.length == 0) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }

    // reverse the linked list RECURSIVELY
    public void reverse() {

        //if our list is empty, return null
        if(head.next==null){
            return;
        }

        //set our head to the result of the reversed list
        head.next = reverse(head.next);
    }

    //https://www.youtube.com/watch?v=BMfqGJTcoms
    private ListNode reverse(ListNode node){

        //as long as there is another node in the list
        if(node.next!=null){
            //save the next node in the list
            ListNode next = node.next;
            //make our current node no longer point to it
            node.next = null;
            //recursively save and remove pointers to the nodes in the rest of the list
            ListNode rest = reverse(next);
            //set the node we saved earlier equal to this node (the reversal part)
            next.next = node;
            //give the rest of the nodes to the earlier call to then be reversed
            return rest;
        }
        //get the last node (head will eventually point to this)
        return node;
    }
}
