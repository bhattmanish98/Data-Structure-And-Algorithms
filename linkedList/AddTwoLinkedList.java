package linkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode last = null;
        ListNode first = null;
        int rem = 0;
        while (l1!=null || l2!=null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (first == null){
                first = new ListNode((sum + rem)%10, null);
                last = first;
            } else {
                last.next = new ListNode((sum + rem)%10, last.next);
                last = last.next;
            }
            if (sum + rem > 9) {
                rem = (sum + rem) / 10;
            } else {
                rem = 0;
            }
        }
        if (rem != 0) {
            last.next = new ListNode(rem, last.next);
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        AddTwoLinkedList addTwoLinkedList = new AddTwoLinkedList();
        ListNode result = addTwoLinkedList.addTwoNumbers(l1, l2);
        System.out.print(result);
    }
}
