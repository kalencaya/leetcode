package cn.sliew.leetcode.string

/**
  * 5838. Check If String Is a Prefix of Array weekly contest
  */
object CheckIfStringIsaPrefixofArray5838ScalaExample {

    def isPrefixString(s: String, words: Array[String]): Boolean = {
        val prefix = new StringBuilder()
        for (str <- words; temp = prefix.toString; if s.startsWith(temp)) {
            prefix.append(str)
            if (prefix.toString.equals(s)) {
                return true
            }
        }
        false
    }

    def main(args: Array[String]): Unit = {
        val s = "z"
        val words = Array("z")
        val result = isPrefixString(s, words)
        println(result)
    }
}
