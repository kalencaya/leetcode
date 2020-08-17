package cn.sliew.leetcode.linkedlist

import cn.sliew.leetcode.ListNode

/**
  * 21.Merge Two Sorted Lists easy
  */
object MergeTwoSortedLists21ScalaExample {

    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
        var left = l1
        var right = l2
        val l = new ListNode(0)
        var p = l
        while (left != null && right != null) {
            if (left.x < right.x) {
                p.next = left
                left = left.next
            } else {
                p.next = right
                right = right.next
            }
            p = p.next
        }

        if (left != null) {
            p.next = left
        }
        if (right != null) {
            p.next = right
        }
        l.next
    }


    def main(args: Array[String]): Unit = {
        val l1 = new ListNode(1)
        l1.next = new ListNode(2)
        l1.next.next = new ListNode(4)

        val l2 = new ListNode(1)
        l2.next = new ListNode(3)
        l2.next.next = new ListNode(4)

        var result = mergeTwoLists(l1, l2)
        while (result != null) {
            print(result.x)
            print(", ")
            result = result.next
        }
    }

}
