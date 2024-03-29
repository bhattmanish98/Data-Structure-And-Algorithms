package LinkedList;

public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode currentNode = null;
        if (list1.val <= list2.val) {
            currentNode = list1;
            list1 = list1.next;
        }
        else {
            currentNode = list2;
            list2 = list2.next;
        }
        ListNode head = currentNode;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                currentNode = list1;
                list1 = list1.next;
            }
            else {
                currentNode.next = list2;
                currentNode = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) currentNode.next = list2;
        else currentNode.next = list1;
        return head;
    }

    public static ListNode mergeTwoListsOneByOne(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode currentNode = list1;
        list1 = list1.next;
        ListNode head = currentNode;
        boolean isList1 = false;
        while(list1 != null && list2 != null) {
            if (isList1) {
                currentNode.next = list1;
                currentNode = list1;
                list1 = list1.next;
                isList1 = false;
            }
            else {
                currentNode.next = list2;
                currentNode = list2;
                list2 = list2.next;
                isList1 = true;
            }
        }
        if (list1 == null) currentNode.next = list2;
        else currentNode.next = list1;
        return head;
    }
}
