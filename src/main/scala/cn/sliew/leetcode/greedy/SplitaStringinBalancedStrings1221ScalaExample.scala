package cn.sliew.leetcode.greedy

import scala.collection.mutable

/**
  * 1221. Split a String in Balanced Strings medium
  */
object SplitaStringinBalancedStrings1221ScalaExample {

    def balancedStringSplit(s: String): Int = {
        val stack = new mutable.Stack[Char]()
        var count = 0
        for (char <- s) {
            if (stack.isEmpty || !isOpposite(stack.top, char)) {
                stack.push(char)
            } else {
                stack.pop()
                if (stack.isEmpty) {
                    count += 1
                }
            }
        }
        count
    }

    private def isOpposite(left: Char, right: Char): Boolean = {
        if (left == 'R') {
            right == 'L'
        } else {
            right == 'R'
        }
    }

    def main(args: Array[String]): Unit = {
        val s = "RLRRRLLRLL"
        val result = balancedStringSplit(s)
        println(result)
    }

}
