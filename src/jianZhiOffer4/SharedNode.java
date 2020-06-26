package jianZhiOffer4;

import java.util.HashSet;

public class SharedNode {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		HashSet<ListNode> nodes = new HashSet<ListNode>();
		while (pHead1 != null && pHead2 != null) {
			if (!nodes.add(pHead1))
				return pHead1;
			if (!nodes.add(pHead2))
				return pHead2;
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		while (pHead1 != null) {
			if (!nodes.add(pHead1))
				return pHead1;
			pHead1 = pHead1.next;
		}
		while (pHead2 != null) {
			if (!nodes.add(pHead2))
				return pHead2;
			pHead2 = pHead2.next;
		}
		return null;
	}

	public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null)
			return null;
		HashSet<ListNode> set = new HashSet<ListNode>();
		while (pHead1 != null) {
			set.add(pHead1);
			pHead1 = pHead1.next;
		}
		while (pHead2 != null) {
			if (set.add(pHead2)) {
				pHead2 = pHead2.next;
			} else {
				return pHead2;
			}
		}
		return null;
	}

	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		int counter1 = 0;
		int counter2 = 0;
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;
		while (cur1 != null) {
			counter1++;
			cur1 = cur1.next;
		}
		while (cur2 != null) {
			counter2++;
			cur2 = cur2.next;
		}
		int gap = Math.abs(counter1 - counter2);
		ListNode longer = null;
		ListNode shorter = null;
		if (counter1 > counter2) {
			longer = pHead1;
			shorter = pHead2;
		} else {
			longer = pHead2;
			shorter = pHead1;
		}
		for (int i = 0; i < gap; i++) {
			longer = longer.next;
		}
		while (longer != null && shorter != null) {
			if (longer.equals(shorter))
				return longer;
			else {
				longer = longer.next;
				shorter = shorter.next;
			}
		}
		return null;
	}

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

}
