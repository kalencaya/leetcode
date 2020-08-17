package cn.sliew.leetcode.tree

object UniqueBinarySearchTrees96ScalaExample {

    def numTrees(n: Int): Int = {
        val g: Array[Int] = new Array[Int](n + 1)
        g(0) = 1
        g(1) = 1

        for (i <- 2 to n; j <- 1 to i) {
            g(i) += g(j - 1) * g(i - j)
        }
        g(n)
    }

    def main(args: Array[String]): Unit = {
        val n = 3
        val result = numTrees(n)
        println(result)
    }
}
