package cn.sliew.leetcode.backtrack

import scala.collection.mutable.ListBuffer

/**
  * 17. Letter Combinations of a Phone Number medium
  * tags: String, Backtracking
  */
object LetterCombinationsofaPhoneNumber17ScalaExample {

    val mapping = Map(
        '2' -> List('a', 'b', 'c'),
        '3' -> List('d', 'e', 'f'),
        '4' -> List('g', 'h', 'i'),
        '5' -> List('j', 'k', 'l'),
        '6' -> List('m', 'n', 'o'),
        '7' -> List('p', 'q', 'r', 's'),
        '8' -> List('t', 'u', 'v'),
        '9' -> List('w', 'x', 'y', 'z'))

    def letterCombinations(digits: String): List[String] = {
        if (digits.isEmpty) {
            return List()
        }

        val result =new  ListBuffer[String]()
        backtrack(new StringBuilder(), 0, digits, result)
        result.toList
    }

    private def backtrack(temp:StringBuilder, start: Int, digits: String, result : ListBuffer[String]): Unit = {
        if (start == digits.length) {
            result += temp.toString
            return
        }

        for (letters <- mapping.get(digits.charAt(start)); letter <- letters) {
            temp.append(letter)
            backtrack(temp, start + 1, digits, result)
            temp.deleteCharAt(temp.length - 1)
        }

    }


    def main(args: Array[String]): Unit = {
        val digits = "23"
        val result = letterCombinations(digits)
        println(result.mkString("[", ",", "]"))
    }
}
