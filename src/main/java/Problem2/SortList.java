package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        if(head==null){
            return head;
        }
        //two pointers (one moves through the list by one each loop, other moves by two (if possible)
        ListNode po = head;
        ListNode p1 = head;

        //if this is the first pass through, dont move po forward by one
        boolean isFirst = true;
        //check if our end isnt already null
        while(p1!=null){
            if(isFirst){
                isFirst = false;
            }
            else{
                //dont move our mid if our end is already going to null
                if(p1.next!=null){
                    po=po.next;
                }
            }
            //move our mid pointer
            p1=p1.next;
            //move our mid pointer again if we can
            if(p1!=null){
                p1=p1.next;
            }
        }
        //save the start of the second list
        ListNode temp = po.next;
        //end the first list before that start
        po.next=null;
        //return the start of the second list
        return temp;
    }

    //https://www.geeksforgeeks.org/merge-two-sorted-lists-place/
    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        //check if either of our current lists are null, if so, the other list has the rest of the sorted vals.
        if(list1==null){
            return list2;
        }
        if(list2==null) {
            return list1;
        }

        //our "current" variable is given to us by the parameters of the function

        //if the val of the current pos on list 1 is smaller than list 2,
        // recursively search for a smaller val past the current pos from either list
        if(list1.val<list2.val){
            list1.next = mergeLists(list1.next, list2);
            return list1;
        }

        //if the val of the current pos on list 2 is smaller than list 1,
        // recursively search for a smaller val past the current pos from either list
        else{
            list2.next = mergeLists(list1, list2.next);
            return list2;
        }
    }

}
