package cn.sliew.leetcode.string

/**
  * 14. Longest Common Prefix easy
  * tags: String
  */
object LongestCommonPrefix14ScalaExample {

    /**
      * 最好的实现思路还是Trie
      */
    def longestCommonPrefix(strs: Array[String]): String = {
        if (strs == null || strs.length == 0) {
            return ""
        }
        if (strs.length == 1) {
            return strs(0)
        }
        val minStr = strs.min(Ordering.by[String, Int](_.length))
        for (i <- 0 until minStr.length) {
            val strings = strs.filterNot(str => str.charAt(i) == minStr.charAt(i))
            if (strings.length != 0) {
                return minStr.substring(0, i)
            }
        }
        minStr
    }

    def longestCommonPrefix2(strs: Array[String]): String = {
        if (strs == null || strs.length == 0) {
            return ""
        }
        if (strs.length == 1) {
            return strs(0)
        }
        val sortedStrs = strs.sortBy(_.length)
        var prefix = sortedStrs(0)
        for (str <- sortedStrs) {
            if (prefix.length == 0) {
                return prefix
            }
            while (prefix.length > 0 && !str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length - 1)
            }
        }
        prefix
    }

    def main(args: Array[String]): Unit = {
        val strs = Array("ca", "a")
        val result = longestCommonPrefix2(strs)
        println(result)
    }


}
