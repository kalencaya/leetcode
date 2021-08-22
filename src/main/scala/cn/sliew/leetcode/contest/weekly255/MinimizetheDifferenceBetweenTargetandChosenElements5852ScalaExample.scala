package cn.sliew.leetcode.contest.weekly255

import scala.collection.mutable.ListBuffer

/**
  * 5852. Minimize the Difference Between Target and Chosen Elements medium
  */
object MinimizetheDifferenceBetweenTargetandChosenElements5852ScalaExample {

    def minimizeTheDifference(mat: Array[Array[Int]], target: Int): Int = {
        backtrack(new ListBuffer[Int](), 0, mat, target, Int.MaxValue)
    }

    private def backtrack(sum: ListBuffer[Int], start: Int, mat: Array[Array[Int]], target: Int, diff: Int): Int = {
        if (start == mat.length) {
            if (sum.length == mat.length) {
                println(sum.mkString("[", ",", "]"))
                return math.abs(target - sum.sum)
            }
            return Int.MaxValue
        }

        if (math.abs(target - sum.sum) >= diff) {
            return diff
        }
        var minDiff = diff
        for (i <- start until mat.length) {
            for (num <- mat(start).sorted.reverse) {
                sum += num
                val result = backtrack(sum, i + 1, mat, target, minDiff)
                minDiff = math.min(result, minDiff)
                sum.remove(sum.length - 1)
            }
        }
        minDiff
    }

    def main(args: Array[String]): Unit = {
        val mat = Array(
            Array(3, 5),
            Array(5, 10),
        )
        val target = 47
        val result = minimizeTheDifference(mat, target)
        println(result)
    }
}
