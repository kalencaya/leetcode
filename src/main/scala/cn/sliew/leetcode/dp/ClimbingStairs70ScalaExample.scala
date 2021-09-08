package cn.sliew.leetcode.dp

import scala.collection.mutable

/**
  * 70. Climbing Stairs easy
  */
object ClimbingStairs70ScalaExample {

    def climbStairs(n: Int): Int = {
        val dp = new mutable.HashMap[Int, Int]()
        dp += 1 -> 1
        dp += 2 -> 2
        recurse(dp, n)
    }

    private def recurse(dp: mutable.HashMap[Int, Int], n: Int): Int = {
        if (dp.get(n).isDefined) {
            return dp.get(n).get
        }
        val way = recurse(dp, n - 1) + recurse(dp, n - 2)
        dp.put(n, way)
        way
    }

    def main(args: Array[String]): Unit = {
        val n = 3
        val result = climbStairs(n)
        println(result)
    }
}
