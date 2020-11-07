package Problem1;

import java.util.Stack;

public class ReverseStack {
    //https://algorithms.tutorialhorizon.com/reverse-a-stack-using-recursion-in-place-without-using-extra-memory/
    public static void reverseStack(Stack<Integer> stack) {
        if(stack==null||stack.size()==0){
            return;
        }

        //Only does the following when stack isn't empty as forced by previous condition

        //pop the values of the stack (will be saved temporarily in each function call) until stack is empty
        int temp = stack.pop();
        reverseStack(stack);
        //insert the current value to the bottom of the stack (the reversing part is here since its to the bottom)
        insertBot(stack, temp);
    }

    private static void insertBot(Stack<Integer> stack, int n){
        //pop the values of the stack (will be saved temporarily in each function call) until stack is empty
        if(stack.size()>0){
            int temp = stack.pop();
            insertBot(stack, n);
            //push back the values of the stack in the order they were already in (as we exit the recursive calls
            stack.push(temp);
        }
        else{
            //push our number to the stack if nothing else is in it
            //this will be the bottom of the stack once all the other nums are added back
            stack.push(n);
        }
    }
}