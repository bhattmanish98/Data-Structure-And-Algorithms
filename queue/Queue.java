package queue;

import java.util.Scanner;

public class Queue {
    static final int MAX_ELEMENTS = 4;
    int[] queue = new int[MAX_ELEMENTS];
    int front = -1;
    int rear = -1;
    private boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    private boolean isFull() {
        return rear == MAX_ELEMENTS -1;
    }

    private void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is Full, can't insert element");
            return;
        }
        if (isEmpty()) {
            front += 1;
        }
        rear += 1;
        queue[rear] = element;
    }

    private int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty, can't delete element");
            return Integer.MIN_VALUE;
        }
        int deletedElement = queue[front];
        front += 1;
        if (front == MAX_ELEMENTS) {
            rear = front = -1;
        }
        return deletedElement;
    }

    private int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return queue[front];
    }

    private void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Elements in queue:");
        for( int i=front;i<=rear;i++) {
            System.out.print(" "+queue[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        boolean isMoreOperations = true;
        while(isMoreOperations) {
            System.out.println("Queue operations");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek\n4. Display\n5. Exit");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter element to add in queue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    element = queue.dequeue();
                    if (element != Integer.MIN_VALUE) System.out.println("Deleted element: "+element);
                    break;
                case 3:
                    element = queue.peek();
                    if (element != Integer.MIN_VALUE) System.out.println("Front element: "+element);
                    break;
                case 4:
                    queue.display();
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
