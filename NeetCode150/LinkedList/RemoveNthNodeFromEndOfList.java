package LinkedList;

import java.util.Stack;

class RemoveNthNodeFromEndOfList {
    // Time Complexity - O(n), Space Complexity - O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        ListNode poped = null;
        while(n-->0) {
            poped = stack.pop();
        }
        if (!stack.isEmpty()) stack.peek().next = poped.next;
        else head = poped.next;
        return head;
    }

    // Time Complexity - O(n)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head==null) return null;
        ListNode dummyNode = new ListNode(0, head);
        ListNode left = dummyNode, right = head;
        while(n-->0) right = right.next;
        while(right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode heaListNode = new ListNode(1, new ListNode(2));
        removeNthNodeFromEndOfList.removeNthFromEnd2(heaListNode, 2);
    }
}
