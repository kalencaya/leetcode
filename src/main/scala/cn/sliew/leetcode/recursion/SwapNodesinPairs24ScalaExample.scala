package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.ListNode

/**
  * 24. Swap Nodes in Pairs medium
  */
object SwapNodesinPairs24ScalaExample {

    def swapPairs(head: ListNode): ListNode = {
        if (head == null || head.next == null) {
            return head
        }

        val newHead = head.next
        head.next = newHead.next
        newHead.next = head
        newHead.next.next = swapPairs(newHead.next.next)
        newHead
    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode(1)
        head.next = new ListNode(2)
        head.next.next = new ListNode(3)
        head.next.next.next = new ListNode(4)

        val result = swapPairs(head)
        var temp = result
        while (temp != null) {
            print(temp.x)
            temp = temp.next
        }
    }
}
