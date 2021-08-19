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
            val combination = temp.toList
            if (result.contains(combination) == false) {
                result += combination
            }
            return
        }
        var ints = temp
        for (i <- start until candidates.length) {
            val tuple = candidates(i)
            for (count <- 0 to tuple._2; if left >= count * tuple._1) {
                val toAdd = List.fill(count)(tuple._1)
                ints = ints ++ toAdd
                backtrack(ints, left - count * tuple._1, i + 1, candidates, result)
                ints = ints -- ints
            }
        }
    }

    def main(args: Array[String]): Unit = {
        val candidates = Array(1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1)
//        val candidates = Array(1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1)
        val target = 30
        val result = combinationSum2(candidates, target)
        result.foreach(list => println(list.mkString("[", ",", "]")))

//        val ints1 = List.fill(3)(1)
//        val ints2 = List.fill(3)(2)
//        val ints = ints1 ++ ints2
//        println(ints1.mkString(","))
//        println(ints2.mkString(","))
//        println(ints.mkString(","))
    }
}
