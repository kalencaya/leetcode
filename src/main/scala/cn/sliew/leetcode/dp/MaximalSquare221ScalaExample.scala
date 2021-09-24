package cn.sliew.leetcode.dp

/**
  * 221. Maximal Square medium
  */
object MaximalSquare221ScalaExample {

    def maximalSquare(matrix: Array[Array[Char]]): Int = {
        val rows = matrix.length
        val cols = matrix(0).length
        val dp = Array.ofDim[Int](rows + 1, cols + 1)
        var maxlen = 0
        for (row <- 1 to rows; col <- 1 to cols) {
            if (matrix(row - 1)(col - 1) == '1') {
                dp(row)(col)= math.min(math.min(dp(row)(col - 1), dp(row - 1)(col)), dp(row - 1)(col - 1)) + 1
                maxlen = math.max(maxlen, dp(row)(col))
            }
        }
        maxlen * maxlen
    }

    def main(args: Array[String]): Unit = {
        val matrix = Array(
            Array('1','0','1','0','0'),
            Array('1','0','1','1','1'),
            Array('1','1','1','1','1'),
            Array('1','0','0','1','0'),
        )

        val result = maximalSquare(matrix)
        println(result)
    }

}
