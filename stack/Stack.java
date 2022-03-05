package stack;

import java.util.Scanner;

public class Stack {
    static final int MAX_ELEMENTS = 4;
    int[] stack = new int[MAX_ELEMENTS];
    int top = -1;

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == MAX_ELEMENTS-1;
    }

    private void push (int element) {
        if (isFull()) {
            System.out.println("Stack is full, can't insert element");
            return;
        }
        top += 1;
        stack[top] = element;
    }

    private int pop () {
        if (isEmpty()) {
            System.out.println("Stack is empty, can't pop element");
            return Integer.MIN_VALUE;
        }
        int deletedElement = stack[top];
        top -= 1;
        return deletedElement;
    }

    private int peek () {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    private void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        System.out.print("Elements in stack:");
        for (int i=0;i<=top;i++) {
            System.out.print(" "+stack[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        boolean isMoreOperations = true;
        while(isMoreOperations) {
            System.out.println("Stack operations");
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    element = stack.pop();
                    if (element != Integer.MIN_VALUE) System.out.println("Deleted element: "+element);
                    break;
                case 3:
                    element = stack.peek();
                    if (element != Integer.MIN_VALUE) System.out.println("Top element: "+element);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    isMoreOperations = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
