package cn.sliew.leetcode.recursion

import scala.collection.mutable.ListBuffer

object CombinationSum39ScalaExample {

    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
        val result = new ListBuffer[List[Int]]()
        backtrack(new ListBuffer[Int](), target, 0, candidates.sorted, result)
        result.toList
    }

    def backtrack(temp: ListBuffer[Int], left: Int, start: Int, candidates: Array[Int], result: ListBuffer[List[Int]]): Unit = {
        if (left == 0) {
            result += temp.toList
            return
        }

        for (i <- start until candidates.length; if left >= candidates(i)) {
            temp += candidates(i)
            backtrack(temp, left - candidates(i), i, candidates, result)
            temp.remove(temp.length - 1)
        }
    }

    def main(args: Array[String]): Unit = {
        val candidates = Array(2, 3, 6, 7)
        val target = 7
        val result = combinationSum(candidates, target)
        result.foreach(list => println(list.mkString("[", ",", "]")))
    }

}
