package LinkedList;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode start = null;
        while(head != null) {
            ListNode a = head.next;
            head.next = start;
            start = head;
            head = a;
        }
        return start;
    }
}
