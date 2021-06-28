package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.ListNode

/**
  * 143. Reorder List medium
  */
object ReorderList143ScalaExample {

    def reorderList(head: ListNode): Unit = {
        if (head == null || head.next == null || head.next.next == null) {
            return
        }

        var prev = head
        var last = head.next
        while (last.next != null) {
            prev = last
            last = last.next
        }
        val next = head.next
        head.next = last
        head.next.next = next
        prev.next = null
        reorderList(next)
    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode(1)
        head.next = new ListNode(2)
        head.next.next = new ListNode(3)
        head.next.next.next = new ListNode(4)
        head.next.next.next.next = new ListNode(5)

        reorderList(head)

        var temp = head
        while (temp != null) {
            print(temp.x)
            temp = temp.next
        }
    }
}
