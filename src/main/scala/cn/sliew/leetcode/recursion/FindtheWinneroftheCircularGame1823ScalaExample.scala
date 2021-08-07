package cn.sliew.leetcode.recursion

import scala.collection.mutable

/**
  * 1823. Find the Winner of the Circular Game medium
  */
object FindtheWinneroftheCircularGame1823ScalaExample {

    def findTheWinner(n: Int, k: Int): Int = {
        val friends = (1 to n).toBuffer
        recurse(1, k, friends)
    }

    private def recurse(start: Int, count: Int, friends: mutable.Buffer[Int]): Int = {
        println(s"start = $start, count = $count, friends = $friends")
        var index = friends.indexOf(start)
        for (i <- 1 until count) {
            index = (index + 1) % friends.length
        }
        val candidate = friends.remove(index)
        if (friends.isEmpty) {
            candidate
        } else {
            recurse(friends(index % friends.length), count, friends)
        }
    }

    def main(args: Array[String]): Unit = {
        val n = 6
        val k = 5
        val result = findTheWinner(n, k)
        println(result)
    }
}
