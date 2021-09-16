package cn.sliew.leetcode.dp

import scala.collection.mutable

/**
  * 139. Word Break medium
  */
object WordBreak139ScalaExample {

    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        val dp = new Array[Boolean](s.length)
        for (i <- 0 until s.length) {
            if (i == 0) {
                dp(i) = true
            } else {

            }
        }
        false
    }

    private def recurse(dp: mutable.HashMap[String, Boolean], s: String, wordDict: List[String]): Boolean = {
        if (s.isEmpty) {
            return true
        }
        if (dp.contains(s)) {
            return dp.get(s).get
        }

        var canBreak = false
        for (i <- 1 to s.length) {
            val word = s.substring(0, i)
            if (wordDict.contains(word) && recurse(dp, s.substring(i), wordDict)) {
                canBreak = true
            }
        }
        dp.put(s, canBreak)
        dp.get(s).get
    }

    def main(args: Array[String]): Unit = {
        val s = "catsandog"
        val wordDict = List("cats","dog","sand","and","cat")
        val result = wordBreak(s, wordDict)
        println(result)
    }
}
