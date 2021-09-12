package cn.sliew.leetcode.contest.weekly258

/**
  * 5868. Number of Pairs of Interchangeable Rectangles medium
  */
object NumberofPairsofInterchangeableRectangles5868ScalaExample {

    def interchangeableRectangles(rectangles: Array[Array[Int]]): Long = {
        var count = 0L

        for (i <- 0 until rectangles.length; j <- i + 1 until rectangles.length) {
            val rectanglei = rectangles(i)
            val rectanglej = rectangles(j)
            val ratioi = BigDecimal.apply(rectanglei(0)) / BigDecimal.apply(rectanglei(1))
            val ratioj = BigDecimal.apply(rectanglej(0)) / BigDecimal.apply(rectanglej(1))
            if (ratioi == ratioj) {
                count += 1
            }
        }

        count
    }

    def main(args: Array[String]): Unit = {
        val rectangles = Array(
            Array(4, 8),
            Array(3, 6),
            Array(10, 20),
            Array(15, 30),
        )

        val result = interchangeableRectangles(rectangles)
        println(result)
    }
}
