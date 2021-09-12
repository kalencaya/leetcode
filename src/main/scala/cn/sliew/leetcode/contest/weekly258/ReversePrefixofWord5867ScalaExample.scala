package cn.sliew.leetcode.contest.weekly258

/**
  * 5867. Reverse Prefix of Word easy
  */
object ReversePrefixofWord5867ScalaExample {

    def reversePrefix(word: String, ch: Char): String = {
        if (word.contains(ch) == false) {
            return word
        }

        val index = word.indexOf(ch)
        word.substring(0, index + 1).reverse + word.substring(index + 1)
    }

    def main(args: Array[String]): Unit = {
        val word = "xyxzxe"
        val ch = 'z'
        val result = reversePrefix(word, ch)
        println(result)
    }
}
