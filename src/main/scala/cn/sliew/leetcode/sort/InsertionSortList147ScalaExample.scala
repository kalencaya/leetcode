package cn.sliew.leetcode.sort

import cn.sliew.leetcode.ListNode

/**
  * 147. Insertion Sort List medium
  */
object InsertionSortList147ScalaExample {

    def insertionSortList(head: ListNode): ListNode = {
        if (head == null) {
            return head
        }
        val helper = new ListNode(0)
        var current = head
        while (current != null) {
            val next = current.next
            var pre = helper
            while (pre.next != null && pre.next.x < current.x ) {
                pre = pre.next
            }
            current.next = pre.next
            pre.next = current
            current = next
        }
        helper.next
    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode(4)
        head.next = new ListNode(2)
        head.next.next = new ListNode(1)
        head.next.next.next = new ListNode(3)
        var result = insertionSortList(head)
        while (result != null) {
            print(result.x)
            print(", ")
            result = result.next
        }
    }

}
