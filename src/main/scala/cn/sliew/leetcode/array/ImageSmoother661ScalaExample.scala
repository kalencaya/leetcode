package cn.sliew.leetcode.array

/**
  * 661.Image Smoother easy
  */
object ImageSmoother661ScalaExample {

    def imageSmoother(M: Array[Array[Int]]): Array[Array[Int]] = {
        val result = Array.ofDim[Int](M.length, M(0).length)
        for (i <- 0 until M.length; j <- 0 until M(i).length) {
            result(i)(j) = floor(i, j, M)
        }
        result
    }

    def floor(i: Int, j: Int, m: Array[Array[Int]]): Int = {
        var sum = m(i)(j)
        var count = 1

        //左
        if (i > 0) {
            sum += m(i - 1)(j)
            count += 1
        }
        //右
        if (i < m.length - 1) {
            sum += m(i + 1)(j)
            count += 1
        }
        //上
        if (j > 0) {
            sum += m(i)(j - 1)
            count += 1
        }
        //下
        if (j < m(i).length - 1) {
            sum += m(i)(j + 1)
            count += 1
        }
        //左上
        if (i > 0 && j > 0) {
            sum += m(i - 1)(j - 1)
            count += 1
        }
        //左下
        if (i > 0 && j < m(i).length - 1) {
            sum += m(i - 1)(j + 1)
            count += 1
        }
        //右上
        if (i < m.length - 1 && j > 0) {
            sum += m(i + 1)(j - 1)
            count += 1
        }
        //右下
        if (i < m.length - 1 && j < m(i).length - 1) {
            sum += m(i + 1)(j + 1)
            count += 1
        }
        math.floor(sum * 1.0 / count).toInt
    }

    def main(args: Array[String]): Unit = {
        val M: Array[Array[Int]] = Array(
            Array(1, 1, 1),
            Array(1, 0, 1),
            Array(1, 1, 1)
        )
        val result = imageSmoother(M)
        result.foreach(arr => println(arr.mkString(" ")))
    }
}
