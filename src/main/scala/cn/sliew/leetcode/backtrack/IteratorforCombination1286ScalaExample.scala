package cn.sliew.leetcode.backtrack

import scala.collection.mutable.ListBuffer

class CombinationIterator(_characters: String, _combinationLength: Int) {

    private val chars = _characters
    private val length = _combinationLength

    private val subStrs: Iterator[String] = allSubStrs().iterator

    private def allSubStrs(): List[String] = {
        val result = new ListBuffer[String]()
        backtrack(new StringBuilder(), length, 0, result)
        println(result.mkString(","))
        result.toList
    }

    private def backtrack(temp: StringBuilder, left: Int, start: Int, result: ListBuffer[String]): Unit = {
        if (left == 0) {
            result += temp.toString
            return
        }
        for (i <- start until chars.length) {
            temp.append(chars(i))
            backtrack(temp, left - 1, start + 1, result)
            temp.deleteCharAt(temp.length - 1)
        }
    }

    def next(): String = {
        subStrs.next()
    }

    def hasNext(): Boolean = {
        subStrs.hasNext
    }
}

/**
  * 1286. Iterator for Combination medium
  */
object IteratorforCombination1286ScalaExample {

    def main(args: Array[String]): Unit = {
        val iterator = new CombinationIterator("abc", 2)
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }

}
