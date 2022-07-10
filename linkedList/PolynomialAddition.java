package linkedList;

import java.util.Scanner;

class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}

public class PolynomialAddition {
    public Node addPolynomial(Node p1,Node p2)
    {
        if (p1 == null) return p2;
        if (p2 == null) return p1;
        Node curr = null, head = null, temp = null;
        while (p1 != null && p2 != null) {
            if (p1.pow == p2.pow) {
                temp = new Node(p1.coeff + p2.coeff, p1.pow);
                p1 = p1.next;
                p2 = p2.next;
            }
            else if (p1.pow > p2.pow) {
                temp = new Node(p1.coeff, p1.pow);
                p1 = p1.next;
            }
            else {
                temp = new Node(p2.coeff, p2.pow);
                p2 = p2.next;
            }
            if (head == null) {
                curr = temp;
                head = temp;
            }
            else {
                curr.next = temp;
                curr = temp;
            }
        }
        if (p1 != null) curr.next = p1;
        else if (p2 != null) curr.next = p2;
        return head;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0) {
            int n = sc.nextInt();
            Node start1 = null, cur1 = null, start2 = null, cur2 = null;
            while (n --> 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Node ptr = new Node(a,b);
                if (start1 == null) {
                    start1 = ptr;
                    cur1 = ptr;
                }
                else {
                    cur1.next = ptr;
                    cur1 = ptr;
                }
            }
            n = sc.nextInt();
            while (n --> 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Node ptr = new Node(a,b);
                if (start2 == null) {
                    start2 = ptr;
                    cur2 = ptr;
                }
                else {
                    cur2.next = ptr;
                    cur2 = ptr;
                }
            }
            PolynomialAddition polynomialAddition = new PolynomialAddition();
            Node sum = polynomialAddition.addPolynomial(start1, start2);
            for (Node ptr=sum;ptr != null;ptr=ptr.next) {
                System.out.print(ptr.coeff+"x^"+ ptr.pow);
                if(ptr.next != null) System.out.print(" + ");
            }
            System.out.println();
        }
    }
}
