package cn.sliew.leetcode.backtrack

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 17. Letter Combinations of a Phone Number medium
  * tags: String, Backtracking
  */
object LetterCombinationsofaPhoneNumber17ScalaExample {

    def letterCombinations(digits: String): List[String] = {
        if (digits.isEmpty) {
            return List()
        }
        val result: mutable.Buffer[String] = new ListBuffer[String]()
        backtrack(digits, 0, new ListBuffer[Char], result)
        result.toList

    }

    private def backtrack(digits: String, index: Int, temp: mutable.Buffer[Char], result: mutable.Buffer[String]): Unit = {
        if (index == digits.length) {
            result += new String(temp.toArray)
            return
        }
        for (letter <- mapping.get(digits(index)).get) {
            temp.insert(index, letter)
            backtrack(digits, index + 1, temp, result)
            temp.remove(index)
        }
    }

    val mapping: mutable.HashMap[Char, List[Char]] = new mutable.HashMap[Char, List[Char]]()
    mapping.put('2', List('a', 'b', 'c'))
    mapping.put('3', List('d', 'e', 'f'))
    mapping.put('4', List('g', 'h', 'i'))
    mapping.put('5', List('j', 'k', 'l'))
    mapping.put('6', List('m', 'n', 'o'))
    mapping.put('7', List('p', 'q', 'r', 's'))
    mapping.put('8', List('t', 'u', 'v'))
    mapping.put('9', List('w', 'x', 'y', 'z'))


    def main(args: Array[String]): Unit = {
        val digits = "23"
        val result = letterCombinations(digits)
        result.foreach(println)
    }
}
