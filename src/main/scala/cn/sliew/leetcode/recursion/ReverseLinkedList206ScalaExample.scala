package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.ListNode

/**
  * 206. Reverse Linked List easy
  */
object ReverseLinkedList206ScalaExample {

    def reverseList(head: ListNode): ListNode = {
        if (head == null || head.next == null) {
            return head
        }
        var oldHead = head.next
        var newHead = head
        newHead.next = null
        while (oldHead != null) {
            val temp = oldHead.next
            oldHead.next = newHead
            newHead = oldHead
            oldHead = temp
        }
        newHead
    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode(1)
        head.next = new ListNode(2)
        head.next.next = new ListNode(3)
        head.next.next.next = new ListNode(4)
        head.next.next.next.next = new ListNode(5)

        val result = reverseList(head)

        var temp = result
        while (temp != null) {
            print(temp.x)
            temp = temp.next
        }
    }
}
