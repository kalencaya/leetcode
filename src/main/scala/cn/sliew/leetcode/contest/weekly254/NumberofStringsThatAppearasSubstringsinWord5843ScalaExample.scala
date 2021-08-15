package cn.sliew.leetcode.contest.weekly254

object NumberofStringsThatAppearasSubstringsinWord5843ScalaExample {

    def numOfStrings(patterns: Array[String], word: String): Int = {
        patterns.filter(pattern => word.contains(pattern)).size
    }

    def main(args: Array[String]): Unit = {
        val patterns = Array("a","abc","bc","d")
        val word = "abc"
        val result = numOfStrings(patterns, word)
        println(result)
    }

}
