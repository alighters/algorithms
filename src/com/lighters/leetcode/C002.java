package com.lighters.leetcode;

/**
 * Created by david on 16/11/2.
 * <p>
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * 思路：很简单的题目，就是需要考虑进位的问题。
 * <p>
 * 优化空间：我这里采用的是一个新的链表结构，可以优化为直接拿 l1 进行更新。
 */
public class C002 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode head = p;
        int carry = 0;
        while (l1 != null && l2 != null) {
            p.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            p.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            p = p.next;
            l2 = l2.next;
        }
        while (carry != 0) {
            p.next = new ListNode(carry % 10);
            carry = carry / 10;
        }
        if (head.next != null) {
            return head.next;
        } else {
            return null;
        }
    }


}
