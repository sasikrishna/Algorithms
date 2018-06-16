package com.algorithms.hackerrank.ctci;

import java.util.Scanner;
import java.util.Stack;

/**
 * Implementing queue data structure using two stack data structures.
 *  
 * @author Sasi Jolla on 14-Jun-2018, 12:16:46 am
 */
public class QueueWithStacks {
	
	public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
        	stackNewestOnTop.push(value);
        }

        public T peek() {
        	prepOldonTopStack();
        	return stackOldestOnTop.peek();
        }

        public T dequeue() {
        	prepOldonTopStack();
        	return stackOldestOnTop.pop();
        }
        
        private void prepOldonTopStack(){
        	if(stackOldestOnTop.isEmpty()){
        		while(!stackNewestOnTop.isEmpty()){
                	stackOldestOnTop.push(stackNewestOnTop.pop());
                }
        	}
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
