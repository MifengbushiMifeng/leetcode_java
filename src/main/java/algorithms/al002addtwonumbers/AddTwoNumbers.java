package algorithms.al002addtwonumbers;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode current = null;

        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int carry = 0;
        int val1, val2;

        while (tmp1 != null || tmp2 != null || carry != 0) {

            val1 = 0;
            val2 = 0;

            if (tmp1 != null) {
                val1 = tmp1.val;
                tmp1 = tmp1.next;
            }

            if (tmp2 != null) {
                val2 = tmp2.val;
                tmp2 = tmp2.next;
            }

            int sum = val1 + val2 + carry;

            if ((double) (sum / 10) >= 1) {

                carry = 1;
                sum = sum % 10;

            } else {
                carry = 0;
            }

            if (result.next == null) {

                result.next = new ListNode(sum);
                current = result.next;

            } else {

                current.next = new ListNode(sum);
                current = current.next;
            }

        }

        return result.next;
    }


    public static void main(String[] args) {

        ListNode l11 = new ListNode(5);
/*        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(1);
        ListNode l15 = new ListNode(1);
        ListNode l16 = new ListNode(1);
        ListNode l17 = new ListNode(1);
        ListNode l18 = new ListNode(1);
        ListNode l19 = new ListNode(1);
        ListNode l110 = new ListNode(1);
        ListNode l111 = new ListNode(1);*/

/*        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        l17.next = l18;
        l18.next = l19;
        l19.next = l110;
        l110.next = l111;*/

        ListNode l21 = new ListNode(5);
/*        ListNode l22 = new ListNode(1);
        ListNode l23 = new ListNode(1);
        ListNode l24 = new ListNode(1);
        ListNode l25 = new ListNode(1);
        ListNode l26 = new ListNode(1);
        ListNode l27 = new ListNode(1);
        ListNode l28 = new ListNode(1);
        ListNode l29 = new ListNode(1);
        ListNode l210 = new ListNode(1);
        ListNode l211 = new ListNode(1);*/

       /* l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        l27.next = l28;
        l28.next = l29;
        l29.next = l210;
        l210.next = l211;*/

        /*l21.next = l22;
        l22.next = l23;*/

        ListNode resultNode = addTwoNumbers(l11, l21);

    }
}
