package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.ListNode

/**
  * 203. Remove Linked List Elements easy
  */
object RemoveLinkedListElements203ScalaExample {

    def removeElements(head: ListNode, value: Int): ListNode = {
        head
    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode(1)
        head.next = new ListNode(2)
        head.next.next = new ListNode(6)
        head.next.next.next = new ListNode(3)
        head.next.next.next.next = new ListNode(4)
        head.next.next.next.next.next = new ListNode(5)
        head.next.next.next.next.next.next = new ListNode(6)

        val value = 6

        val result = removeElements(head, value)

        var temp = result
        while (temp != null) {
            print(temp.x)
            temp = temp.next
        }
    }
}
