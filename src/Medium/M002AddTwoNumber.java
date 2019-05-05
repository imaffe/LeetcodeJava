package Medium;



class M002AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(-1);
        ListNode tail = res;
        // TODO , Should I init var when only needed ? as late as possible?
        int result;
        int carry = 0;
        int mod;
        while (cur1 != null || cur2 != null || carry != 0){
            result = carry;
            if (cur1 != null) result += cur1.val;
            if (cur2 != null) result += cur2.val;
            carry = result / 10;
            mod = result % 10;
            tail.next = new ListNode(mod);
            tail = tail.next;
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }
        return res.next;
    };
};




