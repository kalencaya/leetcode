package cn.sliew.leetcode.recursion

/**
  * 394. Decode String medium
  */
object DecodeString394ScalaExample {

    // s -> N ~ '[' ~ s ~ ']' ~ opt(s) | rep(char)
    def decodeString(s: String): String = {
        null
    }

    def main(args: Array[String]): Unit = {
        val s = "3[a2[c]]"
        val result = decodeString(s)
        println(result)
    }

}
