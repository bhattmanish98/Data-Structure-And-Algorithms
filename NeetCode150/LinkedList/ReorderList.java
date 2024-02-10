package LinkedList;

import java.util.Stack;

// Request: L0 → L1 → … → Ln - 1 → Ln
// Response: L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
public class ReorderList {
    // Time Complexity - O(n), Space Complexity - O(n)
    public void reorderList(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode currNode = head;
        int totalNode = 0;
        while(currNode != null) {
            stack.push(currNode);
            currNode = currNode.next;
            totalNode++;
        }
        currNode = head;
        while(totalNode > 2) {
            ListNode x = currNode.next;
            ListNode y = stack.pop();
            currNode.next = y;
            y.next = x;
            currNode = x;
            totalNode -= 2;
            stack.peek().next = null;
        }
    }

    public void reorderList2(ListNode head) {
        if(head == null) return;
        ListNode first = head, second = head.next;
        while(second != null && second.next != null) {
            first = first.next;
            if (second.next.next != null) second = second.next;
            second = second.next;
        }
        ListNode secondHead = first.next;
        first.next = null;
        secondHead = ReverseLinkedList.reverseList(secondHead);
        head = MergeTwoSortedList.mergeTwoListsOneByOne(head, secondHead);
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode heaListNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList.reorderList2(heaListNode);
    }
}
