package com.dsa.practice.stack;

import java.util.Stack;

public class ParanthesisChecking {
    public static void main(String[] args) {
        System.out.println(ParanthesisChecking.ispar("{}"));
    }

    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        Stack<Character> stack = new Stack<>();

        for(Character c : x.toCharArray()){

            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || !stack.peek().equals('(') ){
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':

                    if(stack.isEmpty() || !stack.peek().equals('{') ){
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || !stack.peek().equals('[') ){
                        return false;
                    }
                    stack.pop();
                    break;

            }

        }

        if(stack.size() > 0){
            return false;
        }

        return true;
    }
}
