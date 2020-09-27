package cn.sliew.leetcode.greedy

/**
  * 392. Is Subsequence easy
  */
object IsSubsequence392ScalaExample {


    def isSubsequence(s: String, t: String): Boolean = {

        for (i <- 0 until t.length) {
            for (j <- 0 until s.length) {
                if (s.charAt(j) != t.charAt(i + j)) {
                    //break
                }
            }
        }
    }
}
