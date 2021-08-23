package cn.sliew.leetcode.dp

/**
  * 1143. Longest Common Subsequence mediym
  */
object LongestCommonSubsequence1143ScalaExample {

    def longestCommonSubsequence(text1: String, text2: String): Int = {
        val result = bruteforce(text1, text2)

        println(result)
        result.length
    }

    private def bruteforce(text1: String, text2: String): String = {
        if (text1.isEmpty || text2.isEmpty) {
            return ""
        }

        val dp = Array.ofDim[String](text1.length, text2.length)

        find(text1, text2, 0, 0, dp)
    }

    private def find(text1: String, text2: String, start1: Int, start2: Int, dp : Array[Array[String]]): String = {
        if (start1 == text1.length || start2 == text2.length) {
            return ""
        }
        if (dp(start1)(start2) != null) {
            return dp(start1)(start2)
        }
        if (text1.charAt(start1) == text2.charAt(start2)) {
            dp(start1)(start2) = text1.charAt(start1) + find(text1, text2, start1 + 1, start2 + 1, dp)
        } else {
            val sub1 = find(text1, text2, start1 + 1, start2, dp)
            val sub2 = find(text1, text2, start1, start2 + 1, dp)
            if (sub1.length > sub2.length) {
                dp(start1)(start2) = sub1
            } else {
                dp(start1)(start2) = sub2
            }
        }
        dp(start1)(start2)
    }

    def main(args: Array[String]): Unit = {
        val text1 = "abcde"
        val text2 = "ace"
        val result = longestCommonSubsequence(text1, text2)
        println(result)
    }

}
