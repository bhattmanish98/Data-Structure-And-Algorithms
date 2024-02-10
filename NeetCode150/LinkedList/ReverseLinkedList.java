package LinkedList;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        
    }
}
