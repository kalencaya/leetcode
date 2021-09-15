package cn.sliew.leetcode.dp

/**
  * 97. Interleaving String medium
  */
object InterleavingString97ScalaExample {

    def isInterleave(s1: String, s2: String, s3: String): Boolean = {
        if (s1.length + s2.length != s3.length) {
            return false
        }

        val dp = Array.ofDim[Boolean](s1.length + 1, s2.length + 1)
        for (i <- 0 until dp.length; j <- 0 until dp(i).length) {
            dp(i)(j) = false
        }
        for (i <- 0 to s1.length; j <- 0 to s2.length) {
            if (i == 0 && j == 0) {
                dp(i)(j) = true
            } else if (i == 0) {
                dp(i)(j) = dp(i)(j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)
            } else if (j == 0) {
                dp(i)(j) = dp(i - 1)(j) && s1.charAt(i - 1) == s3.charAt(i + j - 1)
            } else {
                dp(i)(j) = (dp(i - 1)(j) && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp(i)(j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        dp(s1.length)(s2.length)
    }

    def main(args: Array[String]): Unit = {
        val s1 = "aabcc"
        val s2 = "dbbca"
        val s3 = "aadbbcbcac"

        val result = isInterleave(s1, s2, s3)
        println(result)
    }
}
