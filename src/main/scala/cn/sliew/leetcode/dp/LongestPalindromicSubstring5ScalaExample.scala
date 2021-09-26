package cn.sliew.leetcode.dp

/**
  * 5. Longest Palindromic Substring medium
  */
object LongestPalindromicSubstring5ScalaExample {

    def longestPalindrome(s: String): String = {
        var start = 0
        var end = 0
        for (i <- 0 until s.length) {
            val length1 = expendAroundCenter(s, i, i)
            val length2 = expendAroundCenter(s, i, i + 1)
            val newLength = math.max(length1, length2)
            if (newLength > `end` - start) {
                start = i - (newLength - 1) / 2
                `end` = i + newLength / 2
            }
        }
        s.substring(start, `end` + 1)
    }

    private def expendAroundCenter(s: String, start: Int, end: Int): Int = {
        var left = start
        var right = `end`

        while (left >= 0 && right < s.length && s.charAt(left) == s.charAt(right)) {
            left -= 1
            right += 1
        }
        right - left - 1
    }

    def main(args: Array[String]): Unit = {
        val s = "dccced"
        val result = longestPalindrome(s)
        println(result)
    }
}
