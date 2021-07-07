package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.ListNode

/**
  * 234. Palindrome Linked List easy
  */
object PalindromeLinkedList234ScalaExample {

    def isPalindrome(head: ListNode): Boolean = {
        if (head == null || head.next == null) {
            return true
        }
        if (head.next.next == null) {
            return head.x == head.next.x
        }

        val first = head
        val last = removeLast(first)
        if (first.x == last.x) {
            isPalindrome(first.next)
        } else {
            false
        }
    }

    private def removeLast(head: ListNode): ListNode = {
        var first = head
        var next = head.next
        while (next.next != null) {
            first = next
            next = next.next
        }
        first.next = null

        next
    }

    def main(args: Array[String]): Unit = {
        val head = new ListNode(1)
        head.next = new ListNode(2)
        head.next.next = new ListNode(2)
        head.next.next.next = new ListNode(1)

        val result = isPalindrome(head)
        println(result)
    }
}
