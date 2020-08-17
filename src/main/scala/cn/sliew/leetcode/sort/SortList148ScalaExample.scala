package cn.sliew.leetcode.sort

import cn.sliew.leetcode.ListNode

/**
  * 148. Sort List medium
  */
object SortList148ScalaExample {

    def sortList(head: ListNode): ListNode = {
        if (head == null || head.next == null) {
            return head
        }

        var prev: ListNode = null
        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            prev = slow
            slow = slow.next
            fast = fast.next.next
        }
        //prev是slow的前节点，通过将prev.next置为null，将链表切分为2部分
        prev.next = null

        val l1 = sortList(head)
        val l2 = sortList(slow)

        merge(l1, l2)
    }

    private def merge(l1: ListNode, l2: ListNode): ListNode = {
        var left = l1
        var right = l2
        val l: ListNode = new ListNode(0)
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
        val head = new ListNode(4)
        head.next = new ListNode(2)
        head.next.next = new ListNode(1)
        head.next.next.next = new ListNode(3)
        var result = sortList(head)
        while (result != null) {
            print(result.x)
            print(", ")
            result = result.next
        }
    }
}
