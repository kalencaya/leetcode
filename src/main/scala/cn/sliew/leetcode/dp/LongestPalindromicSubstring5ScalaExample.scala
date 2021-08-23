package cn.sliew.leetcode.dp

/**
  * 5. Longest Palindromic Substring medium
  */
object LongestPalindromicSubstring5ScalaExample {

    def longestPalindrome(s: String): String = {
        var result = ""
        val dp = Array.ofDim[Boolean](s.length, s.length)
        for (i <- s.length - 1 to 0 by -1; j <- i until s.length) {
            dp(i)(j) = (j - i < 3 || dp(i + 1)(j - 1)) && s.charAt(i) == s.charAt(j)
            if (dp(i)(j) && (result == "" || j - i + 1 > result.length())) {
                result = s.substring(i, j + 1)
            }
        }
        result
    }

    def main(args: Array[String]): Unit = {
        val s = "ccc"
        val result = longestPalindrome(s)
        println(result)
    }
}
