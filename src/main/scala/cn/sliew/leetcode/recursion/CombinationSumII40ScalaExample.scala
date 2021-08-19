package cn.sliew.leetcode.recursion

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 40. Combination Sum II medium
  */
object CombinationSumII40ScalaExample {

    def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
        val countBucket = new mutable.TreeMap[Int, Int]()
        for (candidate <- candidates.sorted) {
            if (countBucket.contains(candidate)) {
                countBucket.put(candidate, countBucket.get(candidate).get + 1)
            } else {
                countBucket.put(candidate, 1)
            }
        }

        val result = new ListBuffer[List[Int]]()
        backtrack(new ListBuffer[Int](), target, 0, countBucket.toList, result)
        result.toList
    }

    private def backtrack(temp: ListBuffer[Int], left: Int, start: Int, candidates: List[(Int, Int)], result: ListBuffer[List[Int]]): Unit = {
        if (left == 0) {
            result += temp.toList
            return
        }
        for (i <- start until candidates.length; if candidates(i)._2 > 0) {
            val tuple = candidates(i)
            val candidate = tuple._1
            val count = tuple._2
            temp += candidate
            backtrack(temp, left - candidate, i, candidates.updated(i, (candidate, count - 1)), result)
            temp.remove(temp.length - 1)
        }
    }

    def main(args: Array[String]): Unit = {
        val candidates = Array(14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12)
//        val candidates = Array(1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1)
        val target = 27
        val result = combinationSum2(candidates, target)
        result.foreach(list => println(list.mkString("[", ",", "]")))
    }
}
