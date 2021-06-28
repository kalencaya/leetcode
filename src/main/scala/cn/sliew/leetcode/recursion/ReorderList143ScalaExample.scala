package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.ListNode

/**
  * 143. Reorder List medium
  */
object ReorderList143ScalaExample {

    def reorderList(head: ListNode): Unit = {

    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode(1)
        head.next = new ListNode(2)
        head.next.next = new ListNode(3)
        head.next.next.next = new ListNode(4)

        reorderList(head)

        var temp = head
        while (temp != null) {
            print(temp.x)
            temp = temp.next
        }
    }
}
