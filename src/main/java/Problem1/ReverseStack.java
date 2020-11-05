package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if(stack==null||stack.size()==0){
            return;
        }
        System.out.println("hi");
        reverseStack(stack, stack.pop());
    }

    private static void reverseStack(Stack<Integer> stack, int i){
        if(stack.size()>0){
            int temp = stack.pop();
            reverseStack(stack, i);
            stack.push(temp);
        }
        else{
            System.out.println("i = " + i);
            stack.push(i);
        }
    }
}