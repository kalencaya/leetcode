package cn.sliew.leetcode.backtrack

/**
  * 10. Regular Expression Matching medium
  * tags: Array, Dynamic Programming, Backtracking
  */
object RegularExpressionMatching10ScalaExample {

    def isMatch(s: String, p: String): Boolean = {
        if (p.isEmpty) {
            return s.isEmpty
        }
        val first_match = (!s.isEmpty) &&
            ((p.charAt(0) == s.charAt(0)) || (p.charAt(0) == '.'))

        // s: aabbb
        // p: a*bbb
        if (p.length >= 2 && (p.charAt(1) == '*')){
            isMatch(s, p.substring(2)) ||
                (first_match && isMatch(s.substring(1), p))
        } else {
            first_match && isMatch(s.substring(1), p.substring(1))
        }
    }

    def main(args: Array[String]): Unit = {
        val s = "aabbb"
        val p = "c*bbb"
        val result = isMatch(s, p)
        println(result)
    }
}
