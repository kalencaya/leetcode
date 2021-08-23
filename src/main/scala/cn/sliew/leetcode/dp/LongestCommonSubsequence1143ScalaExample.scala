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

        find(text1, text2, 0, 0)
    }

    private def find(text1: String, text2: String, start1: Int, start2: Int): String = {
        if (start1 == text1.length || start2 == text2.length) {
            return ""
        }
        if (text1.charAt(start1) == text2.charAt(start2)) {
            return text1.charAt(start1) + find(text1, text2, start1 + 1, start2 + 1)
        }
        val sub1 = find(text1, text2, start1 + 1, start2)
        val sub2 = find(text1, text2, start1, start2 + 1)
        if (sub1.length > sub2.length) {
            sub1
        } else {
            sub2
        }
    }

    def main(args: Array[String]): Unit = {
        val text1 = "abcde"
        val text2 = "ace"
        val result = longestCommonSubsequence(text1, text2)
        println(result)
    }

}
