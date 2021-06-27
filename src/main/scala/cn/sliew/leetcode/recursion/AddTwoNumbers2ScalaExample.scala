package cn.sliew.leetcode.recursion

import cn.sliew.leetcode.ListNode

/**
  * 2. Add Two Numbers medium
  */
object AddTwoNumbers2ScalaExample {

    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        val sentinel = new ListNode()
        var c1 = l1
        var c2 = l2
        var d = sentinel
        var sum = 0
        while (c1 != null || c2 != null) {
            sum = sum / 10
            if (c1 != null) {
                sum = sum + c1.x
                c1 = c1.next
            }
            if (c2 != null) {
                sum = sum + c2.x
                c2 = c2.next
            }
            d.next = new ListNode(sum % 10)
            d = d.next
        }
        if (sum / 10 == 1) {
            d.next = new ListNode(1)
        }
        sentinel.next
    }

    def addTwoNumbersRecursive(l1: ListNode, l2: ListNode): ListNode = {
        if (l1 == null && l2 == null){
            return null
        }
        else if (l1 == null) {
            return l2
        }
        else if (l2 == null) {
            return l1
        }

        val value = l1.x + l2.x
        val result = new ListNode(value % 10)
        result.next = addTwoNumbersRecursive(l1.next, l2.next)
        if (value >= 10) {
            result.next = addTwoNumbersRecursive(result.next, new ListNode(1))
        }
        result
    }

    def main(args: Array[String]): Unit = {
        val l1 = new ListNode(0)
        l1.next = new ListNode(8)
        l1.next.next = new ListNode(6)
        l1.next.next.next = new ListNode(5)
        l1.next.next.next.next = new ListNode(6)
        l1.next.next.next.next.next = new ListNode(8)
        l1.next.next.next.next.next.next = new ListNode(3)
        l1.next.next.next.next.next.next.next = new ListNode(5)
        l1.next.next.next.next.next.next.next.next = new ListNode(7)
        val l2 = new ListNode(6)
        l2.next = new ListNode(7)
        l2.next.next = new ListNode(8)
        l2.next.next.next = new ListNode(0)
        l2.next.next.next.next = new ListNode(8)
        l2.next.next.next.next.next = new ListNode(5)
        l2.next.next.next.next.next.next = new ListNode(8)
        l2.next.next.next.next.next.next.next = new ListNode(9)
        l2.next.next.next.next.next.next.next.next = new ListNode(7)

        val result = addTwoNumbersRecursive(l1, l2)

        var temp = result
        while (temp != null) {
            print(temp.x)
            temp = temp.next
        }
    }
}
