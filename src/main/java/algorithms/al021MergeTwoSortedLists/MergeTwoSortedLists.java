package algorithms.al021MergeTwoSortedLists;

import algorithms.al002Addtwonumbers.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode base;
        ListNode compared;

        if (l1.val > l2.val) {

            base = l2;
            compared = l1;

        } else {
            base = l1;
            compared = l2;
        }

        ListNode rt = base;

        ListNode baseNext;
        if (base.next != null) {
            baseNext = base.next;
        } else {
            base.next = compared;
            return base;
        }

        do {

            if (baseNext.val >= compared.val) {

                ListNode newNode = new ListNode(compared.val);
                base.next = newNode;
                newNode.next = baseNext;
                base = newNode;
            } else {
                ListNode newNode = new ListNode(compared.val);

                newNode.next = baseNext.next;
                baseNext.next = newNode;

                base = newNode;
                baseNext = base.next;
            }

            compared = compared.next;
        } while (compared != null);

        return rt;
    }

    private static void addNextNode(ListNode origin, ListNode newNode) {

    }

    private static void addPreNode(ListNode origin, ListNode newNode) {

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(8);
        ListNode l22 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        ListNode rt = mergeTwoLists(l1, l2);
        do {

            System.out.println("----------" + rt.val + "----------");
            rt = rt.next;

        } while (rt != null);
    }

}




