package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        //if we are at the end of the list, end the current frame
        if(list==null){
            return;
        }
        //dives further into list
        printListInReverse(list.next, print);

        //print the value at the current place in the list as we exit the recursive functions
        print.println(list.val);
    }
}
